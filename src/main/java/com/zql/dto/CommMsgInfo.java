package com.zql.dto;

import lombok.Data;

/**
 * Created by 张启磊 on 2019-2-23.
 */
@Data
public  class CommMsgInfo{
    public String content;
    public Long datetime;
    public Long fakeid;
    public Long id;
    public Integer status;
    public Integer type;
}
