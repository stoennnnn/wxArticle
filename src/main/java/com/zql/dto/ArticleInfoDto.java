package com.zql.dto;

import com.zql.dataobject.WechatArticle;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by 26725 on 2019/2/14.
 */
@Data
@ToString
public class ArticleInfoDto {
    //公众号名称
    private String nickname;
    //公众号账号
    private String account;
    //公众号描述
    private String accountDesc;
    //文章信息
    private List<WechatArticle> articles;


}
