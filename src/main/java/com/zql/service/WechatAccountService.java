package com.zql.service;

import com.zql.dataobject.WechatAccount;

/**
 * 微信公众号处理接口
 * Created by 张启磊 on 2019-2-12.
 */
public interface WechatAccountService {
    /**
     * 保存公众号信息
     * @return
     */
    WechatAccount saveAccountInfo();
}
