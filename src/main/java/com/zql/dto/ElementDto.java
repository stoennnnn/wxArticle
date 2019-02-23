package com.zql.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 单个元素结构
 * Created by 张启磊 on 2019-2-12.
 */
@Data
public class ElementDto {
    //两个类做为属性
    @SerializedName("app_msg_ext_info")
    public AppMsgExtInfo appMsgExtInfo = new AppMsgExtInfo();
    @SerializedName("comm_msg_info")
    public CommMsgInfo  commMsgInfo = new CommMsgInfo();
}
