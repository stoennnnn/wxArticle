package com.zql.enums;

/**
 * Created by 张启磊 on 2019-2-13.
 */
public enum ExceptionEnum {
    NONE_ACCOUNT(1,"没有查询到公众号");

    private Integer code;
    private String msg;
    ExceptionEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
