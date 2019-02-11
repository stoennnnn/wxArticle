package com.zql.dataobject;


import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 26725 on 2019/2/11.
 * 公众号实体类
 */
@Entity
@Data
@DynamicUpdate
public class WechatAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountNickname;
    private String accountNumber;
    private String accountDesc;
}
