package com.zql.controller;

import com.zql.dto.ArticleInfoDto;
import com.zql.mq.Producer;
import com.zql.service.serviceImpl.ArticleServiceImpl;
import com.zql.utils.JsonUtil;
import com.zql.utils.RandomUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    private int i = 1;

    /**
     * 把文章信息添加到list并添加到队列
     *
     * @return
     */
    public void articleInfo() {
        List<ArticleInfoDto> list = new ArrayList<>();
        for (String account : accounts) {
            ArticleInfoDto articleInfoDto = run(account);
            if (Optional.ofNullable(articleInfoDto).isPresent()) {
                list.add(articleInfoDto);
            }
        }
        //list不为空则添加到队列
        if (!list.isEmpty()) {
            Destination destination = new ActiveMQQueue("articleQueue");
            //先把list转为json
            final String str = JsonUtil.toJson(list);
            producer.sendMessage(destination, str);
        }
    }

    /**
     * 设置线程睡眠时间5-10秒，过快了要被封
     *
     * @param account
     */
    public ArticleInfoDto run(String account) {
        ArticleInfoDto articleInfoDto = articleServiceImpl.saveLastArticleInfo(account);
        try {
            if (!articleInfoDto.getArticles().isEmpty()) {
                Thread.sleep(RandomUtil.randomInt());
                System.out.println("已经获取到第"+i+"个公众号");
                return articleInfoDto;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArticleInfoDto();
    }
}
