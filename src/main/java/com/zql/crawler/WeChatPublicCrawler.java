package com.zql.crawler;

import com.zql.dto.ElementDto;
import com.zql.dto.IPEntity;
import com.zql.dto.ResultDto;
import com.zql.utils.HTTPUtil;
import com.zql.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class WeChatPublicCrawler {

    @Value("${public.baseUrl}")
    private String baseUrl;

    @Value("${public.ip}")
    private String  ip;

    @Value("${public.port}")
    private int  port;
    /**
     * 通过搜索公众号，获取微信公众号前10条信息
     * 解析doc
     * @param account 微信公众号
     * @return
     */
    public ResultDto getFirst( String account){

        ResultDto resultDto = new ResultDto();
        //需要解析的数据内容
        String content;
        String searchUrl = baseUrl + account;
        IPEntity ipEntity = new IPEntity(ip,port,1);
        Document document = HTTPUtil.getResponseContent(searchUrl, ipEntity, 1, account);
        if (!Optional.ofNullable(document).isPresent()){
            log.error("【通过ip:{}:{} 查询公众号:：{}内容异常】",ip,port,account);
            return new ResultDto();
        }
        //查询到所有列表信息的url
        String listUrl = document.select(".tit a").attr("href");
        if (listUrl.isEmpty()){
            log.error("【没有搜索到公众号listUrl】查看账号：{}是否限制访问" ,account);
            return new ResultDto();
        }
        //System.out.println(listUrl);
        //TODO 这里可能出现输入验证码的情况，以后处理
        Document doc = HTTPUtil.getResponseContent(listUrl, ipEntity, 2, account);
        if (!Optional.ofNullable(doc).isPresent()){
            log.error("【通过ip:{}:{}请求公众号: {}最近10篇文章异常】",ip,port,account);
            return new ResultDto();
        }
        //获取公众号
        Element element = doc.select(".profile_nickname").first();
        if (!Optional.ofNullable(element).isPresent()){
            log.error("【没有取到页面数据element】 查看账号：{}是否限制访问" ,account);
            return new ResultDto();
        }
        String nickname = element.text();
        resultDto.setAccount(account);
        resultDto.setNickname(nickname);
        //获取公众号介绍
        Element element1 = doc.select("ul.profile_desc").first();
        Element descElement = element1.select("div.profile_desc_value").first();
        String accountDesc = descElement.text();
        resultDto.setAccountDesc(accountDesc);
        //获取公众号信息并处理数据，方便转换
        content = doc.html().split("var msgList = ")[1].split("seajs.use")[0].trim();
        content = content.substring(0, content.lastIndexOf(";"));
        content = content.substring(8);
        content = content.substring(0,content.lastIndexOf("}"));
        //json转list，截取前10条推送信息
        List<ElementDto> elementDtos = JsonUtil.toListElementDto(content);
        if(!Optional.ofNullable(elementDtos).isPresent()){
            return new ResultDto();
        }
        resultDto.setElementDtos(elementDtos);
        return resultDto;
    }
}
