package com.zql.utils;

import com.zql.dto.IPEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by 张启磊 on 2019-3-9.
 */
public class HTTPUtil {
    /**
     * 利用httpclient获取网页内容
     * @param url 请求地址
     * @param ipEntity
     * @param num 请求头编号
     * @return
     */
    public static  String getResponseContent(String url, IPEntity ipEntity,int num) {
        //创建httpclient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
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
        //设置请求头
        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        if (num==1)
            httpGet.setHeader("Accept-Encoding","gzip, deflate");
        else if (num==2)
            httpGet.setHeader("Accept-Encoding","gzip, deflate, br");
        httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        httpGet.setHeader("Connection","keep-alive");
        if (num==2)
            httpGet.setHeader("Cache-Control","max-age=0");
        String cookie;
        if (num==1)
            cookie="SUV=004547B275AF843E5A93B8185A12B008; SUID=89F257DF3965860A5A976E37000AB954; IPLOC=CN5101; SNUID=F3DDF3295B5EDFF8A09BF9935C9D73D2; ad=gZllllllll2tbQRUlllllVeHY2ylllllNzMRYlllll9lllllVVxlw@@@@@@@@@@@; ABTEST=7|1551272732|v1; weixinIndexVisited=1; pgv_pvi=8241631232; sct=5";
        else
            cookie="pgv_pvi=9477678080; RK=UGUjybNfuu; ptcz=680f0cc67027b9f0e97ce12eb1ae6379cb4c50706b206eb207d1012bdf6f5236; pgv_pvid=8928723208; ue_ts=1521895380; ue_uk=3005a756aaa8c2b77fe7bebca2771b5f; ue_uid=487b60bfa6473c75689c67a84d815c86; ue_skey=d24e6bf7db06d8ccd5771f16b40204b9; LW_pid=7059ebb825206d974d868ae0824bedfc; tvfe_boss_uuid=97b6c980eb33e04b; o_cookie=1227625521; pgv_pvid_new=1227625521_ec7977abe0; LW_sid=D1G5K2d1Q8R9m5D3H7m9A3q4f2; LW_TS=1521895381; LW_PsKey=4c3d86920ef672b74e2665f107fe5670; _ga=GA1.2.998501291.1533959565; pac_uid=1_1227625521; mobileUV=1_16855cf3348_3ea75; ptui_loginuin=2672575920; sig=h01399da000003a41e6b1b2f40ae477e438a03e380ac2eda6a6c8ec0f33864db57a80a060c68e8fb740";
        httpGet.setHeader("Cookie",cookie);
        if (num==1)
            httpGet.setHeader("Host","weixin.sogou.com");
        else
            httpGet.setHeader("Host","mp.weixin.qq.com");
        httpGet.setHeader("Upgrade-Insecure-Requests","1");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
        CloseableHttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpGet);
            String s = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            Document doc = Jsoup.parse(s);
         //   System.out.println(doc.toString());
            if (s.length()>0)
                return s;
//            if (!Optional.ofNullable(httpResponse).isPresent()) {
//                if (200 == httpResponse.getStatusLine().getStatusCode()) {
//                    String str = EntityUtils.toString(httpResponse.getEntity());
//                    return  str;
//                }
//            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }
}
