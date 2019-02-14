package com.zql.service.serviceImpl;

import com.zql.dataobject.WechatAccount;
import com.zql.dataobject.WechatArticle;
import com.zql.dto.ArticleInfoDto;
import com.zql.dto.ElementDto;
import com.zql.dto.ResultDto;
import com.zql.repository.WechatAccountRepository;
import com.zql.repository.WechatArticleRepository;
import com.zql.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 26725 on 2019/2/13.
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private WechatAccountRepository accountRepository;
    @Autowired
    private WechatArticleRepository articleRepository;

    @Override
    public String saveLastArticleInfo() {
        ResultDto resultDto = accountServiceImpl.saveAccountInfo();
        //需要插入队列的articleInfoDto
        ArticleInfoDto articleInfoDto = new ArticleInfoDto();
        BeanUtils.copyProperties(resultDto, articleInfoDto);
        if (!Optional.ofNullable(resultDto).isPresent()) {
            log.error("resultDto不存在");
            return "false";
        }
        //获取该公众号已信息
        List<WechatAccount> list = accountRepository.findByAccountNumber(resultDto.getAccount());
        if (!Optional.ofNullable(list).isPresent()) {
            log.error("没有查询到公众号");
            return "false";
        }
        Integer accountId = list.get(0).getAccountId();
        WechatArticle article = new WechatArticle();
        article.setAccountId(accountId);
        //取最新的一篇文章
        ElementDto elementDto = resultDto.getElementDtos().get(0);
        //先判断之前是否保存过文章
        List<WechatArticle> articles = articleRepository.findByAccountId(accountId);
        //第一次保存公众号文章
        if (articles.isEmpty()) {
            saveOneArticle(article, elementDto,articleInfoDto);
            //如果一天发了多篇文章
            if (!elementDto.getAppMsgExtInfo().multiAppMsgItemList.isEmpty()) {
                saveMultiArticle(elementDto, articleInfoDto);
            }
        } else {
            Long timeLong = articles.get(0).getArticleDatetime();
            //判断文章是否更新
            if(!timeLong.equals(elementDto.getCommMsgInfo().datetime)){
                //保存文章
                saveOneArticle(article, elementDto,articleInfoDto);
                //如果一天发了多篇
                if (!elementDto.getAppMsgExtInfo().multiAppMsgItemList.isEmpty()) {
                    saveMultiArticle(elementDto,articleInfoDto);
                }
            }else {
                log.debug("文章还没更新");
                return "false";
            }
        }
        return "true";
    }

    /**
     * 保存文章信息
     *
     * @param article
     * @param elementDto
     */
    public void saveOneArticle(WechatArticle article, ElementDto elementDto,ArticleInfoDto articleInfoDto) {
        //标题，文章链接，描述，封面，更新时间
        String title = elementDto.getAppMsgExtInfo().title;
        String contentUrl = elementDto.getAppMsgExtInfo().contentUrl;
        String digest = elementDto.getAppMsgExtInfo().digest;
        String cover = elementDto.getAppMsgExtInfo().cover;
        //datetime格式为long
        Long datetime = elementDto.getCommMsgInfo().datetime;
        article.setArticleTitle(title);
        article.setArticleContentUrl(contentUrl);
        article.setArticleDigest(digest);
        article.setArticleCoverUrl(cover);
        //datetime以long保存
        article.setArticleDatetime(datetime);
        articleRepository.save(article);
        //顺便插入articleInfoDto
        List<WechatArticle> articles = articleInfoDto.getArticles();
        articles.add(article);
    }

    /**
     * 一天发多篇文章的情况的保存
     * @param elementDto
     */
    public void saveMultiArticle(ElementDto elementDto,ArticleInfoDto articleInfoDto){
        List<ElementDto.AppMsgExtInfo.MultiAppMsgItemInfo> multiAppMsgItemList = elementDto.getAppMsgExtInfo().multiAppMsgItemList;
        for (int i = 0; i < multiAppMsgItemList.size(); i++) {
            WechatArticle article2 = new WechatArticle();
            saveOneArticle(article2, elementDto,articleInfoDto);
        }
    }
}
