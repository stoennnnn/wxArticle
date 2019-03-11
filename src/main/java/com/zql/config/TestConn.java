package com.zql.config;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

/**
 * Created by 26725 on 2019/3/11.
 */
@Component
public class TestConn {
    public void getResponseContent(HttpGet articleHeaderBean) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(articleHeaderBean);
        String s = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Document doc = Jsoup.parse(s);
    }
}
