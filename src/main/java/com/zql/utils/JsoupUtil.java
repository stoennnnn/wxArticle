package com.zql.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by 张启磊 on 2019-3-20.
 */
public class JsoupUtil {
    /**
     * 通过post发送数据
     * @param url
     * @param key
     * @param value
     */
    public static String setHttpPost(String url, String key, String value) {
        Connection connect = Jsoup.connect(url);
        connect.data(key, value);

        try {
            Document doc  = connect.post();
            System.out.println(doc);
        } catch (IOException e) {
            e.printStackTrace();
            return  "false";
        }
        return  "true";
    }
}
