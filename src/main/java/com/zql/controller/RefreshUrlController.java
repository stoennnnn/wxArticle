package com.zql.controller;

import com.zql.service.serviceImpl.RefreshUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

/**
 * 重新获取文章链接并返回
 * Created by 26725 on 2019/2/21.
 */
//这里要做页面跳转，只能用controller注解
@Controller
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
    @GetMapping("/newurl")
    public ModelAndView refreshUrl(@RequestParam Integer accountId,
                                   @RequestParam Integer articleId) {
        Map<String, String> resultMap = refreshUrlServiceImpl.refreshUrl(accountId, articleId);
        ModelAndView model = new ModelAndView();
        model.setViewName("skip");
//        try {
//            //请求太快容易导致被封
//            Thread.sleep(RandomUtil.randomInt());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (Optional.ofNullable(resultMap).isPresent()){
            if ("false".equals(resultMap.get("result"))) {
                //获取文章newUrl失败
                model.addObject("key","false");
                return model;
            } else if ("true".equals(resultMap.get("result"))) {
                //返回newUrl
                String newUrl = resultMap.get("newUrl");
                model.addObject("key",newUrl);
                return model;
            } else {
                //其它情况
                model.addObject("key","false");
                return model;
            }
        }else{
            //resulMap值为空
            model.addObject("key","false");
            return model;
        }
    }

}
