package com.zql.dto;

import lombok.Data;

import java.util.List;

/**
 * 最外层bean结构
 * Created by 张启磊 on 2019-2-11.
 */
@Data
public class AppMsgExtInfo {
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
    private Integer isMulti;
    private Integer itemShowType;
    private Integer maliciousContentType;
    private Integer maliciousTitleReasonId;
    private List<MultiAppMsgItemInfo> multiAppMsgItemList;
    private String playUrl;
    private String sourceUrl;
    private Integer subtype;
    private String  title;
    private CommMsgInfo CommMsgInfo;
}
