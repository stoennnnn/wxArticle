package com.zql.service;

import com.zql.dataobject.WechatAccount;
import com.zql.dto.ResultDto;

/**
 * 微信公众号处理接口
 * Created by 张启磊 on 2019-2-12.
 */
public interface AccountService {
    /**
     * 保存公众号信息
     * @return
     */
    ResultDto saveAccountInfo();
}
