package com.zql.controller;

import com.zql.dto.ArticleInfoDto;
import com.zql.mail.SendMail;
import com.zql.service.serviceImpl.ArticleServiceImpl;
import com.zql.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 在controller层调用
 * 消息中间件监听
 * Created by 26725 on 2019/2/14.
 */
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleServiceImpl;
    @Autowired
    private SendMail sendMail;
    //公众号集合
    @Value("${public.account}")
    private List<String> accounts;
    private int i = 1;

    /**
     * 把文章信息添加到list并添加到队列
     *
     * @return
     */
    @GetMapping("/everyday")
    public String articleInfo() {
        List<ArticleInfoDto> list = new ArrayList<>();
        for (String account : accounts) {
            ArticleInfoDto articleInfoDto = run(account);
            if (Optional.ofNullable(articleInfoDto).isPresent()) {
                list.add(articleInfoDto);
            }
        }

        //list里面嵌套了list，肯定不为空，这里要对内层list判空；不为空，则添加到队列。
        if (list.get(0).getArticles().size()>0) {
            try {
                sendMail.send(list,"article.ftl");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
//            Destination destination = new ActiveMQQueue("articleQueue");
//            //先把list转为json
//            final String str = JsonUtil.toJson(list);
//            producer.sendMessage(destination, str);
            return "文章已经成功发送到队列";
        }
        return "无文章更新";
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
               log.info("已经获取到第"+i+++"个公众号:{}",account);
                return articleInfoDto;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArticleInfoDto();
    }

    @GetMapping("/detail")
    public String  articleDetail(){
        String articleContent = articleServiceImpl.findArticleDetail(346, 3);
        return  articleContent;
    }
}
