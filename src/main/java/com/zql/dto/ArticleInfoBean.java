package com.zql.dto;

import lombok.Data;
import java.util.List;

/**
 * 只用于gson转换bean
 * 和ArticleInfoDto部分重复，先这样写
 * Created by 26725 on 2019/2/18.
 */
@Data
public class ArticleInfoBean {
    //公众号名称
    public String nickname;
    //公众号账号
    public String account;
    //公众号描述
    public String accountDesc;
    //文章信息
    public List<WechatArticle> articles ;

    public static class WechatArticle {
        public Integer articleId;
        public Integer accountId;
        public String articleTitle;
        public String articleDigest;
        public String articleContentUrl;
        public String articleCoverUrl;
        public Long articleDatetime;
    }
}
