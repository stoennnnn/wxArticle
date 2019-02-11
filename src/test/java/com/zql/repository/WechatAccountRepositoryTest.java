package com.zql.repository;

import com.zql.dataobject.WechatAccount;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static javax.print.attribute.standard.MediaSizeName.A;
import static org.junit.Assert.*;

/**
 * Created by 26725 on 2019/2/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatAccountRepositoryTest {
    @Autowired
    private WechatAccountRepository repository;
    @Test
    public void save(){
        WechatAccount wechatAccount = new WechatAccount();
        wechatAccount.setAccountNickname("java团长");
        wechatAccount.setAccountNumber("aa123");
        wechatAccount.setAccountDesc("测试");
        repository.save(wechatAccount);
    }
    @Test
    public void  findByNickname(){
        List<WechatAccount> result = repository.findByAccountNickname("aa123");
        Assert.assertNotEquals(0,result.size());
    }
    @Test
    public void findByAccountNumber(){
        List<WechatAccount> res = repository.findByAccountNumber("aa123");
        Assert.assertNotEquals(0,res.size());
    }
}