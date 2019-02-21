package com.zql.service.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by 张启磊 on 2019-2-21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RefreshUrlServiceImplTest {
    @Autowired
    private  RefreshUrlServiceImpl refreshUrlServiceImol;
    @Test
    public void testUrl() throws Exception {
        String  url="https://mp.weixin.qq.com/s?timestamp=1550671403&src=3&ver=1&signature=ijI7RvQ97NOkLwdylHjqS*wRhXWMwY3ORfF-ByJfT-wxuNa1Cd-N9j2XYRfjErSwu3igaNCIFGwwKrG-WYaK7jyZV9Hytvm7xm-TMJ-tYV8iUuVhfjtxBIVxR9TF0iND9hwbNlYjCx7l3gXGox2QfZ6kDJLXJaSihejPLJ4PKhk=";
        refreshUrlServiceImol.refreshUrl("javatuanzhang","跳槽季如何快速全面的复习面试题",url);
    }

    @Test
    public void test(){
        boolean b = Optional.ofNullable(null).isPresent();
        System.out.println(b);
    }
}