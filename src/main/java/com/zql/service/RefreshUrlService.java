package com.zql.service;

/**
 * 邮箱里的链接处理service
 * Created by 张启磊 on 2019-2-20.
 */
public interface RefreshUrlService {
    void refreshUrl(String account,String title,String url);
}
