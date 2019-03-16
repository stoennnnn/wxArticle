package com.zql.service.serviceImpl;

import com.zql.crawler.ArticleDetailCrawler;
import com.zql.dataobject.WechatAccount;
import com.zql.dataobject.WechatArticle;
import com.zql.dto.*;
import com.zql.repository.ArticleImageRepository;
import com.zql.repository.WechatAccountRepository;
import com.zql.repository.WechatArticleRepository;
import com.zql.service.ArticleService;
import com.zql.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文章信息处理serwviceImpl
 * 包含保存和发送
 * Created by 26725 on 2019/2/13.
 */
@Service
@Slf4j
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private WechatAccountRepository accountRepository;
    @Autowired
    private WechatArticleRepository articleRepository;
    @Autowired
    private ArticleDetailCrawler articleDetailCrawler;
    @Autowired
    private ArticleImageRepository imageRepository;
    @Value("${public.urlHead}")
    private String urlHead;
    @Override
    public ArticleInfoDto saveLastArticleInfo(String account ) {
        ResultDto resultDto = accountServiceImpl.saveAccountInfo(account);
        //需要插入队列的articleInfoDto
        ArticleInfoDto articleInfoDto = new ArticleInfoDto();
        BeanUtils.copyProperties(resultDto, articleInfoDto);
        if (!Optional.ofNullable(resultDto.getElementDtos()).isPresent()) {
            return new ArticleInfoDto();
        }
        //获取accountId
        List<WechatAccount> list = accountRepository.findByAccountNumber(account);
        if (list.isEmpty()) {
            log.error("没有查询到公众号");
            return new ArticleInfoDto();
        }
        Integer accountId = list.get(0).getAccountId();
        WechatArticle article = new WechatArticle();
        //外层数据先存入accountId
        article.setAccountId(accountId);
        //取最新的一篇文章
        ElementDto elementDto = resultDto.getElementDtos().get(0);
        //先判断之前是否保存过该公众号文章
        List<WechatArticle> articles = articleRepository.findByAccountId(accountId);
        //第一次保存公众号文章
        if (articles.isEmpty()) {
            saveOneArticle(article, elementDto,articleInfoDto);
            //如果一天发了多篇文章
            if (!elementDto.getAppMsgExtInfo().multiAppMsgItemList.isEmpty()) {
                saveMultiArticle(elementDto, articleInfoDto, accountId);
            }
        } else {
            Long timeLong = articles.get(0).getArticleDatetime();
            //判断文章是否更新
            if(!timeLong.equals(elementDto.getCommMsgInfo().datetime)){
                //保存文章
                saveOneArticle(article, elementDto,articleInfoDto);
                //如果一天发了多篇
                if (!elementDto.getAppMsgExtInfo().multiAppMsgItemList.isEmpty()) {
                    saveMultiArticle(elementDto,articleInfoDto,accountId);
                }
            }else {
                log.error("【文章还没更新】{}",account);
                return new ArticleInfoDto();
            }
        }
        return articleInfoDto;
    }

    /**
     * 查询文章详细内容
     * @param articleId
     * @return
     */
    @Override
    public String findArticleDetail(int articleId) {
        WechatArticle article = articleRepository.findByArticleId(articleId);
        String content = article.getArticleContent();
        return  content;
    }


    /**
     * 根据url返回正文包含的图片url集合
     * @param articleInfoDto
     */
    @Override
    public List<ImageUrlDto> getLastArticleDetail(ArticleInfoDto  articleInfoDto) {
        List<WechatArticle> articles = articleInfoDto.getArticles();
        List<ImageUrlDto> list = new ArrayList();
        for (WechatArticle article : articles) {
            //避免请求过快，每个请求间隔10-15s
            Thread thread = new Thread();
            try {
                thread.sleep(RandomUtil.randomInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Document doc = articleDetailCrawler.getDetail(article);
            if (!Optional.ofNullable(doc).isPresent()) {
                return new ArrayList();
            }
            //获取正文内容，正文只有一个
            Element elementContent = doc.select(".rich_media_content").get(0);
            //获取图片url
            Elements imgUrls = elementContent.getElementsByTag("img");
            for (int i = 0; i < imgUrls.size(); i++) {
                //获取老的url
                String imgOldUrl = imgUrls.get(i).attr("data-src");
//                //把data_src属性删除
//                elementContent.getElementsByTag("img").get(i).removeAttr("data-src");
                //增加src属性并把oldurl添加进去，图片就能正常显示
                elementContent.getElementsByTag("img").get(i).select("img").attr("src", imgOldUrl);
                //每个图片url都保存为一个dto
                ImageUrlDto imageUrlDto = new ImageUrlDto();
                //把articleId，accountId复制过去
                BeanUtils.copyProperties(article, imageUrlDto);
                imageUrlDto.setImgOurl(imgOldUrl);
                list.add(imageUrlDto);
            }
            //保存正文内容和格式
            articleRepository.updateContentById(elementContent.toString(), article.getArticleId());
        }
        return list;
    }

    /**
     * 保存文章信息
     *
     * @param article
     * @param elementDto
     */
    @Transactional
    public void saveOneArticle(WechatArticle article, ElementDto elementDto,ArticleInfoDto articleInfoDto) {
        //标题，文章链接，描述，封面，更新时间
        String title = elementDto.getAppMsgExtInfo().title;
        //需要处理contentUrl
        String contentUrl = elementDto.getAppMsgExtInfo().contentUrl.replaceAll("amp;","");
        //System.out.println(urlHead+contentUrl);
        String digest = elementDto.getAppMsgExtInfo().digest;
        String cover = elementDto.getAppMsgExtInfo().cover;
        //datetime格式为long,乘以1000存放，freemarker可以直接转换.不用
        Long datetime = elementDto.getCommMsgInfo().datetime;
        article.setArticleTitle(title);

        article.setArticleContentUrl(urlHead+contentUrl);
        article.setArticleDigest(digest);
        article.setArticleCoverUrl(cover);
        //datetime以long保存
        article.setArticleDatetime(datetime);
        articleRepository.save(article);
        //同时插入articleInfoDto
        articleInfoDto.getArticles().add(article);
    }

    /**
     * 一天发多篇文章的情况的保存
     * @param elementDto
     */
    @Transactional
    public void saveMultiArticle(ElementDto elementDto,ArticleInfoDto articleInfoDto,Integer accountId){
        List<MultiAppMsgItemInfo> multiAppMsgItemList = elementDto.getAppMsgExtInfo().multiAppMsgItemList;
        for (int i = 0; i < multiAppMsgItemList.size(); i++) {
            WechatArticle article2 = new WechatArticle();
            article2.setArticleTitle(multiAppMsgItemList.get(i).title);
            //contentUrl需要处理
            article2.setArticleContentUrl(urlHead+multiAppMsgItemList.get(i).contentUrl.replaceAll("amp;",""));
            article2.setArticleDigest(multiAppMsgItemList.get(i).digest);
            article2.setArticleCoverUrl(multiAppMsgItemList.get(i).cover);
            article2.setArticleDatetime(elementDto.getCommMsgInfo().datetime);
            article2.setAccountId(accountId);
            articleRepository.save(article2);
            //同时插入articleInfoDto
            articleInfoDto.getArticles().add(article2);
        }
    }
}
