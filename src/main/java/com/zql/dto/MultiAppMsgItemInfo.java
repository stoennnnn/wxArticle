package com.zql.dto;

import lombok.Data;

/**
 * 嵌套的list结构
 * Created by 张启磊 on 2019-2-11.
 */
@Data
public class MultiAppMsgItemInfo {
    private Integer audioFileid;
    private String author;
    private String content;
    private String contentUrl;
    private Integer copyrightStat;
    private String cover;
    private Integer delFlag;
    private String digest;
    private Integer duration;
    private Integer fileid;
    private Integer itemShowType;
    private Integer maliciousContentType;
    private Integer maliciousTitleReasonId;
    private String playUrl;
    private String sourceUrl;
    private String  title;
}
