package com.zql.config;

import com.zql.dto.IPEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 26725 on 2019/3/11.
 */
@Configuration
public class HeaderConfig {
    @Bean(name="articleHeaderBean")
    public HttpGet articleHeaderBean() {
        String url = "https://mp.weixin.qq.com/s?timestamp=1552266222&src=3&ver=1&signature=2cTNSsUOLoBibx2ucN4vPaqmTzc4coz*bJ4U-fl9EeRUNxP80jWOzHBvrqaA4aFVWjGLpNZ0gp*OH-JwE169q0lW*I*IhDIDeqsze0DikhKvb1zy1oND1l-rtDvqEw2UiMED75DOZErZ2747H72pEMIuSZqMzoJrbM5DzI9AbKk=";
        IPEntity ipEntity = new IPEntity("119.27.170.46", 8888, 1);
        //创建httpGet实例
        HttpGet httpGet = new HttpGet(url);
        //设置代理
        HttpHost proxy;
        RequestConfig requestConfig;
        if (null != ipEntity) {
            proxy = new HttpHost(ipEntity.getIp(), ipEntity.getPort());
            //设置请求超时和读取超时时间，如果返回200则视为有效ip
            requestConfig = RequestConfig.custom()
                    .setProxy(proxy)
                    .setConnectTimeout(5000)//设置连接超时时间
                    .setConnectionRequestTimeout(5000) // 设置请求超时时间
                    .setSocketTimeout(5000)
                    .build();
        }else{
            requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000)//设置连接超时时间
                    .setConnectionRequestTimeout(5000) // 设置请求超时时间
                    .setSocketTimeout(5000)
                    .build();
            httpGet.setConfig(requestConfig);
        }
        //设置请求头
//        httpGet.setHeader("Accept", " image/webp,*/*");
//        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
    //    httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//        httpGet.setHeader("Cache-Control","max-age=0");
//        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Host", "res.wx.qq.com");
     //   httpGet.setHeader("Referer","https://mp.weixin.qq.com/s?timestamp=1552266222&src=3&ver=1&signature=2cTNSsUOLoBibx2ucN4vPaqmTzc4coz*bJ4U-fl9EeRUNxP80jWOzHBvrqaA4aFVWjGLpNZ0gp*OH-JwE169q0lW*I*IhDIDeqsze0DikhKvb1zy1oND1l-rtDvqEw2UiMED75DOZErZ2747H72pEMIuSZqMzoJrbM5DzI9AbKk=");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:65.0) Gecko/20100101 Firefox/65.0");
        return httpGet;
    }

}
