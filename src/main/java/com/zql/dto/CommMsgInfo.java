package com.zql.dto;

import lombok.Data;

import java.sql.Date;

/**
 * 评论信息bean
 * Created by 张启磊 on 2019-2-11.
 */
@Data
public class CommMsgInfo {
    private String content;
    private Date datetime;
    private Integer id;
    private Integer status;
    private Integer type;
}