package com.zql.dataobject;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by 26725 on 2019/2/11
 * 文章信息实体类
 */
@Entity
@Data
@DynamicUpdate
public class WechatArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer  articleId;
    private Integer accountId;
    private String articleTitle;
    private String articleDigest;
    private String articleContentUrl;
    private String articleCoverUrl;
    private Long articleDatetime;
}
