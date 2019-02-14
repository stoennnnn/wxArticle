package com.zql.service.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-2-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {
    @Autowired
    private ArticleServiceImpl  articleServiceImpl;
    @Test
    public void saveLastArticleInfo() throws Exception {
      //  articleServiceImpl.saveLastArticleInfo();
    }

}