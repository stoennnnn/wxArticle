package com.zql.repository;

import com.zql.dataobject.WechatUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by 张启磊 on 2019-2-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRespositoryTest {
    @Autowired
    private UserRespository respository;
    @Test
    public void  save(){
        WechatUser user = new WechatUser();
        user.setUserName("3测试");
        user.setPassword("123664");
        respository.save(user);
        System.out.println(user);
    }
    @Test
    public void  find() {
        List<WechatUser> byUserBame = respository.findByUserName("3测试");
        System.out.println(byUserBame);
    }

}