package com.zql.quartz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-2-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTaskTest {
    @Autowired
    private ArticleTask articleTask;
    @Test
    public void execute() {
        articleTask.execute();
        //System.out.println("任务调度测试：" + System.currentTimeMillis());
    }

}