package com.zql.service.serviceImpl;

import com.zql.dataobject.WechatAccount;
import com.zql.dataobject.WechatArticle;
import com.zql.dto.ElementDto;
import com.zql.dto.ResultDto;
import com.zql.repository.WechatAccountRepository;
import com.zql.repository.WechatArticleRepository;
import com.zql.service.AccountService;
import com.zql.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 26725 on 2019/2/13.
 */
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private WechatAccountRepository accountRepository;
    @Autowired
    private WechatArticleRepository articleRepository;
    @Override
    public WechatArticle saveLastArticleInfo() {
        WechatArticle article = new WechatArticle();
        ResultDto resultDto = accountServiceImpl.saveAccountInfo();
        if (!Optional.ofNullable(resultDto).isPresent()){

        }
        //获取accountId
        List<WechatAccount> list = accountRepository.findByAccountNumber(resultDto.getAccount());
        if (Optional.ofNullable(list).isPresent()){
            return null;
        }
        Integer accountId = list.get(0).getAccountId();
        article.setAccountId(accountId);
        //取最新的一篇文章
        ElementDto elementDto = resultDto.getElementDtos().get(0);
        //先判断文章是否更新
        List<WechatArticle> articles = articleRepository.findByAccountId(accountId);
        if (!Optional.ofNullable(articles).isPresent()){
            //标题
            String title = elementDto.getAppMsgExtInfo().title;
            //文章链接
            String contentUrl = elementDto.getAppMsgExtInfo().contentUrl;
            //描述
            String digest = elementDto.getAppMsgExtInfo().digest;
            //封面
            String cover = elementDto.getAppMsgExtInfo().cover;
            //更新时间
            Long datetime = elementDto.getCommMsgInfo().datetime;
            article.setArticleTitle(title);
            article.setArticleContentUrl(contentUrl);
            article.setArticleDigest(digest);
            article.setArticleCoverUrl(cover);



        }
        // articleRepository.finb
        return null;
    }
}
