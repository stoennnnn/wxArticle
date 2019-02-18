package com.zql.utils;

import com.zql.crawler.WeChatPublicCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-2-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilTest {
    @Autowired
    private WeChatPublicCrawler weChatPublic;
    @Test
    public void toList() {
        String str="[{\n" +
                "\t\"nickname\": \"Java技术栈\",\n" +
                "\t\"account\": \"javastack\",\n" +
                "\t\"accountDesc\": \"专注分享Java技术干货，包括多线程、JVM、Spring Boot、Spring Cloud、Intellij IDEA、Dubbo、Zookeeper、Redis、架构设计、微服务、消息队列、Git、面试题、程序员攻略、最新动态等。\",\n" +
                "\t\"articles\": [{\n" +
                "\t\t\t\"articleId\": 31,\n" +
                "\t\t\t\"accountId\": 2,\n" +
                "\t\t\t\"articleTitle\": \"阿里跳槽拼多多，80万年薪涨到160万，值不值得去？\",\n" +
                "\t\t\t\"articleDigest\": \"很多人现在找工作的话既想找一份不辛苦薪资要高还要有前途的工作，但世界上有这么便宜的事情吗，显然没有啊。\",\n" +
                "\t\t\t\"articleContentUrl\": \"https://mp.weixin.qq.com/s?timestamp\\u003d1550472672\\u0026src\\u003d3\\u0026ver\\u003d1\\u0026signature\\u003dS6Ck7Jdj-dGNBZ0ownV8JUe59Mas8pCuI95F5GNpT8PdZRuhBDUqKsYxR30uTfFevTs-NCfG117CSgdqer3TqUFJ7H0jhpA2ZlyEfGJ7QzarE3QrUzD8*Q7RnTkZb8MYHoXOTb1jxyX870-TJ4pBOKcKux30MEaa64aeB0g1Hb4\\u003d\",\n" +
                "\t\t\t\"articleCoverUrl\": \"http://mmbiz.qpic.cn/mmbiz_jpg/TNUwKhV0JpRWJduZka8QlVBks4FrSR7JLh6RiaDr4qpryZ7rq8LENIicIb0JhUmpXUzyolicxOADeNhCKoauTUogg/0?wx_fmt\\u003djpeg\",\n" +
                "\t\t\t\"articleDatetime\": 1550450460\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"articleId\": 32,\n" +
                "\t\t\t\"accountId\": 2,\n" +
                "\t\t\t\"articleTitle\": \"来，重新认识一个强大的 Gson！\",\n" +
                "\t\t\t\"articleDigest\": \"从一个 Bug 说起。。\",\n" +
                "\t\t\t\"articleContentUrl\": \"https://mp.weixin.qq.com/s?timestamp\\u003d1550472672\\u0026src\\u003d3\\u0026ver\\u003d1\\u0026signature\\u003dS6Ck7Jdj-dGNBZ0ownV8JUe59Mas8pCuI95F5GNpT8PdZRuhBDUqKsYxR30uTfFevTs-NCfG117CSgdqer3TqUFJ7H0jhpA2ZlyEfGJ7QzYjO9nk5-FSOyLq0YbeR2rFR1XYn4qQb1-iiRQQdMIrJkFYgNoXTv0zWO0-WztVAXw\\u003d\",\n" +
                "\t\t\t\"articleCoverUrl\": \"http://mmbiz.qpic.cn/mmbiz_jpg/TNUwKhV0JpRWJduZka8QlVBks4FrSR7JhZiauakZlpoibFPO9sLqUIYBjfuDel4QicRbribIKEYgA7BRyut9xKoN7g/0?wx_fmt\\u003djpeg\",\n" +
                "\t\t\t\"articleDatetime\": 1550450460\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}]";
        JsonUtil.toArticleInfoBeans(str);
    }

}