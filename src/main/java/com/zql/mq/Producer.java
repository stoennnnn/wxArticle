package com.zql.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * 定义一个生产者
 * Created by 26725 on 2019/2/14.
 */
@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    public  void sendMessage(Destination destination, Object obj) {
        jmsTemplate.convertAndSend(destination,obj);
    }

}
