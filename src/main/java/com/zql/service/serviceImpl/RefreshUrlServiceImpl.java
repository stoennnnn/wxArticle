package com.zql.service.serviceImpl;

import com.zql.dto.ElementDto;
import com.zql.dto.ResultDto;
import com.zql.service.RefreshUrlService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    /**
     * 链接过期后重新刷新链接
     * @param account 账号
     * @param title
     */
    @Override
    public void refreshUrl(String account, String title, String url) {
            String result = testUrl(url);
            if ("true".equals(result)){
                return;
            }
            //文章已过期
            else if ("false".equals(result)){
                //重新取出最新的10篇文章
                ResultDto resultDto = accountServiceImpl.saveAccountInfo(account);
                //ofNullable:若果不为null创建空实例，isPresent判断是否包含值
                if(!Optional.ofNullable(resultDto).isPresent()){
                    //todo
                    List<ElementDto> elementDtos = resultDto.getElementDtos();
                    //遍历外层是否包含标题
                    elementDtos.stream().filter(ElementDto::getAppMsgExtInfo).map(e -> e.getAppMsgExtInfo().title.equals(title)).findFirst();
                    //遍历嵌套list是否包含标题
                    Optional<ElementDto> second = elementDtos.stream().filter(e -> e.getAppMsgExtInfo().multiAppMsgItemList.stream().map(f -> f.title).equals(title)).findFirst();
                    //如果有，取出新的url
                    if (1==1){

                        return
                    }
                }

            }
    }

    /**
     * 测试url是否过期
     * 以Response Header是否包含 Content-Security-Policy判断
     * @param url
     * @return
     */
    public String testUrl(String url) {
        Connection.Response execute =null;
        try {
            execute = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .execute();
        } catch (IOException e) {
            log.error("【文章地址解析异常】，地址为：{}",url);
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
