package com.zql.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * Created by 张启磊 on 2019-3-3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {
    @Autowired
    private Producer producer;
    @Test
    public void sendMessage() throws Exception {
         Destination destination = new ActiveMQQueue( "articleQueue" );
        producer.sendMessage(destination, "woaini" );
    }

}