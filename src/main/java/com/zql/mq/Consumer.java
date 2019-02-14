package com.zql.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 创建消费者，通过消费者监听并发送邮件
 * Created by 26725 on 2019/2/14.
 */
@Component
public class Consumer {
    @JmsListener(destination="queue_article")
    public void receiveInfo(){

    }
}
