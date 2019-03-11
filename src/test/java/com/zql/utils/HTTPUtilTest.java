package com.zql.utils;

import com.zql.config.HeaderConfig;
import com.zql.config.TestConn;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 26725 on 2019/3/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HTTPUtilTest {
    @Autowired
    private TestConn conn;
    @Test
    public void getResponseContent() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HeaderConfig.class);
        HttpGet articleHeaderBean = applicationContext.getBean(HttpGet.class);
        conn.getResponseContent( articleHeaderBean);

    }

}