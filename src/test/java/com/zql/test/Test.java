package com.zql.test;

import com.zql.dataobject.WechatArticle;
import com.zql.repository.WechatArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-3-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private WechatArticleRepository repository;
    //重新格式化文章的正文，秩取中文内容
    @org.junit.Test
    public  void  test(){
        WechatArticle article = repository.findByArticleId(392);
        Document doc = Jsoup.parse(article.getArticleContent());
        Elements select = doc.select(".rich_media_content");
        String s = select.get(0).toString();
        repository.updateContentById(s,392);


    }
}
