package com.zql.quartz;

import org.springframework.stereotype.Component;

/**
 * 通过微信公众号获取最新的文章定时任务
 * Created by zql on 2019-2-19.
 */
@Component
public class ArticleTask {
    public void execute()  {
        System.out.println("任务调度测试："+System.currentTimeMillis());
    }
}
