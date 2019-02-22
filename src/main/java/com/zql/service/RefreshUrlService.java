package com.zql.service;

import java.util.Map;

/**
 * 邮箱里的链接处理service
 * Created by 张启磊 on 2019-2-20.
 */
public interface RefreshUrlService {
    Map<String, String> refreshUrl(String accountId, String articleId);
}
