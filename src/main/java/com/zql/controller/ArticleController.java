package com.zql.controller;

import com.zql.dto.ArticleInfoDto;
import com.zql.dto.ImageUrlDto;
import com.zql.mail.SendMail;
import com.zql.mq.Producer;
import com.zql.service.serviceImpl.ArticleServiceImpl;
import com.zql.utils.JsonUtil;
import com.zql.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
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
    @GetMapping("/everyday")
    public String articleInfo() {
        List<ArticleInfoDto> list = new ArrayList<>();
        for (String account : accounts) {
            ArticleInfoDto articleInfoDto = run(account);
            if (Optional.ofNullable(articleInfoDto).isPresent()) {
                //添加到用于发送邮件的list
                list.add(articleInfoDto);
                //网络还不通，暂时不通过队列下载图片，从数据库取
               //把图片的url添加到队列
                List<ImageUrlDto> imageUrls = articleServiceImpl.getLastArticleDetail(articleInfoDto);
                Destination destination = new ActiveMQQueue("imageUrlQueue");
                //先把list转为json
                final String str = JsonUtil.toJson(imageUrls);
                //每篇文章发送一个消息
                producer.sendMessage(destination, str);
            }
        }

        //list里面嵌套了list，肯定不为空，这里要对内层list判空；
        // 不为空，则发送邮件，并且把图片url发送到队列
        if (list.get(0).getArticles().size()>0) {
            try {
                sendMail.send(list,"article.ftl");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

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

    /**
     * 获取文章内容
     * @return
     */
    @GetMapping("/detail")
    public String  articleDetail(){
        String articleContent = articleServiceImpl.findArticleDetail(346);
        return  articleContent;
    }

}
