package com.zql.utils;

import com.zql.crawler.WeChatPublicCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-2-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilTest {
    @Autowired
    private WeChatPublicCrawler weChatPublic;
    @Test
    public void toList() {
        weChatPublic.getFirst("jj");
    }

}