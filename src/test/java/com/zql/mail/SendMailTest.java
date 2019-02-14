package com.zql.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Created by 26725 on 2019/2/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailTest {
    @Autowired
    private JavaMailSender mailSender;
    @Test
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("2672575920@qq.com");
        message.setTo("2672575920@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}