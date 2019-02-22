package com.zql.controller;

import com.zql.service.serviceImpl.RefreshUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * 重新获取文章链接并返回
 * Created by 26725 on 2019/2/21.
 */
@RestController
@RequestMapping("/refresh")
public class RefreshUrlController {
    @Autowired
    private RefreshUrlServiceImpl refreshUrlServiceImpl;

    /**
     * 直接返回新的url，不用去校验旧的url，减少请求次数
     * @param accountId
     * @param articleId
     * @return
     */
    @PostMapping("/newurl")
    public String refreshUrl(@RequestParam String accountId,
                             @RequestParam String articleId) {
        Map<String, String> resultMap = refreshUrlServiceImpl.refreshUrl(accountId, articleId);
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
