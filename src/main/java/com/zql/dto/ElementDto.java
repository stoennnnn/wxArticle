package com.zql.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 结果处理bean
 * Created by 张启磊 on 2019-2-12.
 */
@Data
public class ElementDto {
    @SerializedName("app_msg_ext_info")
    public AppMsgExtInfo appMsgExtInfo;
    @SerializedName("comm_msg_info")
    public CommMsgInfo  commMsgInfo;

    public static class AppMsgExtInfo{
        @SerializedName("author")
        public String author;
        @SerializedName("multi_app_msg_item_list")
        public List<MultiAppMsgItemInfo> multiAppMsgItemList;

        public static class MultiAppMsgItemInfo{
            @SerializedName("audio_fileid")
            public Integer audioFileid;
        }
    }

    public static class CommMsgInfo{
        @SerializedName("content")
        public String content;
    }

}
