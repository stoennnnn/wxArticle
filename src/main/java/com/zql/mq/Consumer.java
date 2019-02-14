package com.zql.mq;

import com.zql.dto.ArticleInfoDto;
import com.zql.mail.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 创建消费者，通过消费者监听并发送邮件
 * Created by 26725 on 2019/2/14.
 */
@Component
public class Consumer {
    @Autowired
    private SendMail sendMail;
    @JmsListener(destination="articleQueue")
    public void receiveInfo( List<ArticleInfoDto> list ){
        //发邮件
        sendMail.send(list);
    }
}
