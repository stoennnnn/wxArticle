package com.zql.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 26725 on 2019/2/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {
    @Autowired
    private ArticleController articleController;
    @Test
    public void testValueAnno(){
        articleController.test();
    }
}