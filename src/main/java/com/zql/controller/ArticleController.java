package com.zql.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 26725 on 2019/2/14.
 */
@RestController
@ConfigurationProperties
public class ArticleController {
    @Value("${public.account}")
    private List<String> accounts;

    public void test(){
    }


}
