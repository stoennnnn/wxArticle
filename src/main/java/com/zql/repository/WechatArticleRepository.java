package com.zql.repository;

import com.zql.dataobject.WechatArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by 26725 on 2019/2/11.
 */
public interface WechatArticleRepository extends JpaRepository<WechatArticle,Integer> {
    //查找该公众号所有的文章并排序
    @Query(value="select a from WechatArticle a where a.accountId =?1 order by a.articleDatetime desc")
    List<WechatArticle> findByAccountId(Integer accountId);
    //查找该公众号的特定文章
    WechatArticle findByArticleIdAndAccountId(Integer article, Integer accountId);
}
