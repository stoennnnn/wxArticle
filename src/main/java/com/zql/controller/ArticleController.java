package com.zql.controller;

import com.zql.dto.ArticleInfoDto;
import com.zql.mq.Producer;
import com.zql.service.serviceImpl.ArticleServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.List;

/**
 * 在controller层调用
 * 消息中间件监听
 * Created by 26725 on 2019/2/14.
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleServiceImpl;
    @Autowired
    private Producer producer;
    //公众号集合
    @Value("${public.account}")
    private List<String> accounts;
    public void articleInfo(){
        List<ArticleInfoDto> list = new ArrayList<ArticleInfoDto>();
        for (String account : accounts) {
            ArticleInfoDto articleInfoDto = articleServiceImpl.saveLastArticleInfo(account);
            if (!articleInfoDto.getArticles().isEmpty()){
                list.add(articleInfoDto);
            }
        }
        //list不为空则添加到队列
        if(!list.isEmpty()){
            Destination destination = new ActiveMQQueue("articleQueue");
            producer.sendMessage(destination,list.toString());
        }
    }
}
