package com.zql.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeChatPublic {
    public void getFirst(){
        String baseUrl = "http://weixin.sogou.com/weixin?type=1&ie=utf8&query=";//搜狗微信的基础地址
        String searchUrl = baseUrl + "javastack";//加上安泰科现货价格的微信公总号
        Document document = getDocument(searchUrl);
        String listUrl = document.select(".tit a").attr("href");//查询到所有列表信息的url
        System.out.println(listUrl);
        System.out.println("-----------------------");
        Document doc = getDocument(listUrl);
        //截取前10条推送信息的json中的list数据
        String jsonList = doc.html().split("var msgList = ")[1].split("seajs.use")[0].trim();
        //截取出来第一条信息的url
        String url = jsonList.split("content_url\":\"")[1].split("\",\"copyright_stat")[0].replaceAll("amp;", "");
        if(url.startsWith("/s")){//如果url以/s开头，处理成http格式
            url = "http://mp.weixin.qq.com" + url;
        }
        System.out.println(url);
        //获取第一条推送信息的标题
        String title = jsonList.split("title\":\"")[1].split("\"},\"comm_msg_info")[0];
        System.out.println(title);
    }

    /**
     * 获取页面
     * @author siqiangming 2018年5月9日 下午2:23:01
     * @param url url
     * @return
     */
    public Document getDocument(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
