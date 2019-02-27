package com.zql.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张启磊 on 2019-2-28.
 */
@RestController
public class RegisterAndLoginController  {
    @RequestMapping("/")
    public String view(){
        return "LoginAndRegister";
    }
}
