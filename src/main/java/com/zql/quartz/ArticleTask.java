package com.zql.quartz;

import com.zql.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 将要定时执行的job
 * Created by zql on 2019-2-19.
 */
@Component
@Slf4j
public class ArticleTask {
    @Autowired
    private ArticleController articleController;
    //需要执行的方法
    public void execute()  {
        articleController.articleInfo();
        log.info("任务调度执行完毕："+new Date().getTime());
    }
}
