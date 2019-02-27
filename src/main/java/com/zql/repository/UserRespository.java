package com.zql.repository;

import com.zql.dataobject.WechatUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 张启磊 on 2019-2-27.
 */
public interface UserRespository extends JpaRepository<WechatUser,Integer>{
    List<WechatUser> findByUserName(String useraName) ;

}
