package com.zql.service.serviceImpl;

import com.zql.dataobject.WechatAccount;
import com.zql.dto.ElementDto;
import com.zql.dto.ResultDto;
import com.zql.repository.WechatAccountRepository;
import com.zql.service.RefreshUrlService;
import com.zql.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by 张启磊 on 2019-2-20.
 */
@Service
@Slf4j
public class RefreshUrlServiceImpl implements RefreshUrlService {
    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private WechatAccountRepository accountRepository;
    @Value("${public.baseUrl}")
    private String baseUrl;
    /**
     * 链接过期后重新刷新链接
     * @param accountId 账号id
     * @param articleId 文章id
     */
    @Override
    public Map<String, String> refreshUrl(String accountId,  String articleId) {
        Map<String, String> resultMap = new HashMap<>();
        //测试文章链接是否过期
 //       String result = testUrl(url);
//        if ("true".equals(result)) {
//            resultMap.put("result", "false");
//            return resultMap;
//        } else if ("false".equals(result)) {
        //通过accountId和articleId 获取account和title
        List<WechatAccount> accountList = accountRepository.findByAccountNickname(nickName);
        if (Optional.ofNullable(accountList).isPresent()) {
            log.error("【根据nickeName查找公众号失败！】：{}", nickName);
            resultMap.put("result", "false");
            return resultMap;
        }
        String account= accountList.stream().filter(e -> e.getAccountNickname().equals(nickName)).map(e -> e.getAccountNumber()).toString();
        //文章已过期
        //重新取出最新的10篇文章
        ResultDto resultDto = accountServiceImpl.saveAccountInfo(account);
        //ofNullable:若果不为null创建空实例，isPresent判断是否包含值
        if (Optional.ofNullable(resultDto).isPresent()) {
            //todo
            List<ElementDto> elementDtos = resultDto.getElementDtos();
            //遍历外层是否包含标题
            Optional<String> first = null;
            String contentUrl = null;
            try {
                first = elementDtos.stream().filter(e -> e.getAppMsgExtInfo().title.equals(title))
                        .map(e -> e.getAppMsgExtInfo().contentUrl)
                        .findFirst();
                //如果first没有值
                if (!first.isPresent()) {
                    Optional<List<ElementDto.AppMsgExtInfo.MultiAppMsgItemInfo>> second = elementDtos.stream()
                            .map(e -> e.getAppMsgExtInfo().multiAppMsgItemList).findFirst();
                    //遍历内层list
                    if (second.isPresent()) {
                        List<ElementDto.AppMsgExtInfo.MultiAppMsgItemInfo> multiAppMsgItemInfos = second.get();
                        contentUrl = multiAppMsgItemInfos.stream().filter(f -> f.title.equals(title))
                                .map(f -> f.contentUrl).toString().replace("amp;", "");
                    }
                } else {
                    //如果外层有值，直接取出来
                    contentUrl = first.get().replace("amp;", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultMap.put("result", "true");
            resultMap.put("newUrl", baseUrl + contentUrl);
        } else {
            log.error("【根据账号重新获取文章失败】,{}", account);
            resultMap.put("result", "false");
            return resultMap;
        }
        return resultMap;
    }

    /**
     * 测试url是否过期
     * 以Response Header是否包含 Content-Security-Policy判断
     * 先不校验
     * @param url
     * @return
     */
    public String testUrl(String url) {
        Connection.Response execute =null;
        try {
            execute = Jsoup.connect(url)
                    //todo 设置请求头
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .execute();
        } catch (IOException e) {
            log.error("【文章地址解析异常】，地址为：{}",url);
            e.printStackTrace();
        }
        //线程睡眠5-10秒，否则容易出现验证码
        try {
            Thread.sleep(RandomUtil.randomInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, String> headers = execute.headers();
        if ( headers.containsKey("Content-Security-Policy")){
            return "true";
        }else {
            return "false";
        }
    }
}
