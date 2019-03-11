package com.zql.crawler;

import com.zql.dataobject.WechatArticle;
import com.zql.dto.ArticleInfoDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Created by 张启磊 on 2019-3-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDetailCrawlerTest {
    @Autowired
    private  ArticleDetailCrawler crawler;
    @Test
    public void getDetail() throws Exception {
        ArticleInfoDto dto = new ArticleInfoDto();
        WechatArticle article = new WechatArticle();
        article.setArticleContentUrl("https://mp.weixin.qq.com/s?timestamp=1552308999&src=3&ver=1&signature=0DSLlcFDaILJPWItrJEx9n91Z9cqJRFFe1B4GwlueH3VwHuI8F8zWPjGn94MTcLPRR51YZYrnjMd4EbtSOmY*yrmgJWDlh0wmAXg4fMOcEOmJBQgwwb256FVhFOtQviyvkpFM3i932PrGSdcaIpXferBATkleUisqBFRpgwCAyw=");
        article.setArticleId(346);
        ArrayList list = new ArrayList();
        list.add(article);
        dto.setArticles(list);
        crawler.getDetail(dto);
    }

}