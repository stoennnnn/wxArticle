package com.zql.repository;

/**
 * Created by 26725 on 2019/2/11.
 */

import com.zql.dataobject.WechatAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WechatAccountRepository  extends JpaRepository<WechatAccount,Integer>{
     List<WechatAccount> findByAccountNickname(String accountNickname);
     List<WechatAccount> findByAccountNumber(String ccountNumber);

}
