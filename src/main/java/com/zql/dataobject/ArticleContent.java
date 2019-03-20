package com.zql.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 26725 on 2019/3/19.
 */
@Entity
@Data
@DynamicUpdate
public class ArticleContent {
    @Id
    private Integer articleId;
    private Integer accountId;
    private String articleContent;
}
