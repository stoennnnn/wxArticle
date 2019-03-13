package com.zql.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;


/**
 * Created by 26725 on 2019/3/13.
 */
@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendMessage(Destination destination, String messgae){
        jmsTemplate.convertAndSend(destination,messgae);

    }
}
