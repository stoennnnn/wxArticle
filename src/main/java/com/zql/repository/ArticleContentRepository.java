package com.zql.repository;


import com.zql.dataobject.ArticleContent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 张启磊 on 2019-3-19.
 */
public interface ArticleContentRepository extends JpaRepository<ArticleContent,Integer> {
}
