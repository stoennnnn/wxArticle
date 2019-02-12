package com.zql.repository;

import com.zql.dataobject.WechatArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 26725 on 2019/2/11.
 */
public interface WechatArticleRepository extends JpaRepository<WechatArticle,Integer> {
}
