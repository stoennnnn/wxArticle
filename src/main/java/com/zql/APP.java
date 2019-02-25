package com.zql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * extends SpringBootServletInitializer
 * 打包用的
 * Created by 26725 on 2019/2/11.
 */
@SpringBootApplication
public class APP extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(APP.class,args);
    }
    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return  builder.sources(this.getClass());
    }
}
