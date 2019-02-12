package com.zql.crawler;

import com.zql.dto.ElementDto;
import com.zql.utils.JsonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WeChatPublicCrawler {

    @Value("${public.baseUrl}")
    private String baseUrl;

    /**
     * 获取微信公众号前10条信息
     * @param account 微信公众号
     * @return
     */
    public List<ElementDto> getFirst( String account){
        //需要解析的数据内容
        String content;
        String searchUrl = baseUrl + account;
        Document document = getDocument(searchUrl);
        //查询到所有列表信息的url
        String listUrl = document.select(".tit a").attr("href");
        //这里可能出现输入验证码的情况，以后处理
        //TODO
        if (!Optional.ofNullable(listUrl).isPresent()){
            return new ArrayList<>();
        }
        Document doc = getDocument(listUrl);
        //获取公众号
        Element element = doc.select(".profile_nickname").first();
        String nickname = element.text();
        //获取公众号介绍
        Element element1 = doc.select("ul.profile_desc").first();
        Element descElement = element1.select("div.profile_desc_value").first();
        String accountDesc = descElement.text();
        //获取文章信息并处理数据，方便转换
        content = doc.html().split("var msgList = ")[1].split("seajs.use")[0].trim();
        content = content.substring(0, content.lastIndexOf(";"));
        content = content.substring(8);
        content = content.substring(0,content.lastIndexOf("}"));
        //json转list，截取前10条推送信息
        List<ElementDto> elementDtos = JsonUtil.toList(content);//截取出来第一条信息的url
        if(!Optional.ofNullable(elementDtos).isPresent()){
            return new ArrayList<>();
        }
        return elementDtos;
    }

    /**
     * 获取页面
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