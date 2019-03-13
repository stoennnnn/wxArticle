package com.zql.dto;

import lombok.Data;

/**
 * 包含未替换的url dto
 * Created by 26725 on 2019/3/13.
 */
@Data
public class ImageUrlDto {
    private Integer accountId;
    private Integer articleId;
    private String imgOurl;
}
