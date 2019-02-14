package com.zql.service;

import com.zql.dto.ArticleInfoDto;

/**
 * Created by 26725 on 2019/2/13.
 */
public interface ArticleService {
    ArticleInfoDto saveLastArticleInfo(String account);
}
