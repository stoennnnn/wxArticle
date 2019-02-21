package com.zql.controller;

import com.zql.service.serviceImpl.RefreshUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * 重新获取文章链接并返回
 * Created by 26725 on 2019/2/21.
 */
@RestController
public class RefreshUrlController {
    @Autowired
    private RefreshUrlServiceImpl refreshUrlServiceImpl;

    public String refreshUrl(String account, String title, String url) {
        Map<String, String> resultMap = refreshUrlServiceImpl.refreshUrl(account, title, url);
        if (Optional.ofNullable(resultMap).isPresent()){
            if ("false".equals(resultMap.get("result"))) {
                return "";
            } else if ("true".equals(resultMap.get("result"))) {
                String newUrl = resultMap.get("newUrl");
                return newUrl;
            } else {
                return "";
            }
        }else{
            return "";
        }
    }

}
