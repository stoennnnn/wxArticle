package com.zql.service;

import com.zql.dto.ArticleInfoDto;
import com.zql.dto.ImageUrlDto;

import java.util.List;

/**
 * Created by 26725 on 2019/2/13.
 */
public interface ArticleService {
    ArticleInfoDto saveLastArticleInfo(String account);
    String findArticleDetail(int articleId);
    List<ImageUrlDto> getLastArticleDetail(ArticleInfoDto articleInfoDto);
}
