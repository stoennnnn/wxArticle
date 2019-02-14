package com.zql.repository;

import com.zql.dataobject.WechatArticle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

/**
 * Created by 26725 on 2019/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatArticleRepositoryTest {
    @Autowired
    private WechatArticleRepository repository;
    @Test
    public void  save(){
        WechatArticle wechatArticle = new WechatArticle();
       // Date date = new Date(1549769380);
        wechatArticle.setAccountId(1);
        wechatArticle.setArticleContentUrl("www.baidu.com");
        wechatArticle.setArticleCoverUrl("www.baidu.com");
        wechatArticle.setArticleDigest("java学习公众号");
        wechatArticle.setArticleTitle("我们都来学java");
        wechatArticle.setArticleDatetime(12L);
        repository.save(wechatArticle);
    }

    @Test
    public  void findByAccountId(){
        List<WechatArticle> list = repository.findByAccountId(1);
        Assert.assertNotNull(list);
    }

}