package com.zql.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by 张启磊 on 2019-3-19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientPostTest {
    @org.junit.Test
    public void test(){
        Connection connect = Jsoup.connect("http://47.101.207.245:8080/image/geturls");
        connect.data("articleContents", "zhangsan");
        try {
            Document doc = connect.post();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
