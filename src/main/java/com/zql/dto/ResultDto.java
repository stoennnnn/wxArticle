package com.zql.dto;

import lombok.Data;
import java.util.List;

/**
 * Created by 26725 on 2019/2/13.
 */
@Data
public class ResultDto {
    //公众号名称
    private String nickname;
    //公众号账号
    private String account;
    //公众号描述
    private String accountDesc;
    //前10篇文章信息
    private List<ElementDto> elementDtos;
}
