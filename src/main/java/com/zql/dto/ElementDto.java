package com.zql.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 单个元素结构
 * Created by 张启磊 on 2019-2-12.
 */
@Data
public class ElementDto {
    //两个类做为属性
    @SerializedName("app_msg_ext_info")
    public AppMsgExtInfo appMsgExtInfo;
    @SerializedName("comm_msg_info")
    public CommMsgInfo  commMsgInfo;

    public static class AppMsgExtInfo{
        @SerializedName("audio_fileid")
        public Integer audioFileid;
        public String author;
        public String content;
        @SerializedName("content_url")
        public String contentUrl;
        @SerializedName("copyright_stat")
        public Integer copyrightStat;
        public String cover;
        @SerializedName("del_flag")
        public Integer delFlag;
        public String digest;
        public Integer duration;
        public Long fileid;
        @SerializedName("is_multi")
        public Integer isMulti;
        @SerializedName("item_show_type")
        public Integer itemShowType;
        @SerializedName("malicious_content_type")
        public Integer maliciousContentType;
        @SerializedName("malicious_title_reason_id")
        public Integer maliciousTitleReasonId;
        @SerializedName("multi_app_msg_item_list")
        public List<MultiAppMsgItemInfo> multiAppMsgItemList;
        @SerializedName("play_url")
        public String playUrl;
        @SerializedName("source_url")
        public String sourceUrl;
        public Integer subtype;
        public String  title;

        public static class MultiAppMsgItemInfo{
            @SerializedName("audio_fileid")
            public Integer audioFileid;
            public String author;
            public String content;
            @SerializedName("content_url")
            public String contentUrl;
            @SerializedName("copyright_stat")
            public Integer copyrightStat;
            public String cover;
            @SerializedName("del_flag")
            public Integer delFlag;
            public String digest;
            public Integer duration;
            public Long fileid;
            @SerializedName("item_show_type")
            public Integer itemShowType;
            @SerializedName("malicious_content_type")
            public Integer maliciousContentType;
            @SerializedName("malicious_title_reason_id")
            public Integer maliciousTitleReasonId;
            @SerializedName("play_url")
            public String playUrl;
            @SerializedName("source_url")
            public String sourceUrl;
            public String  title;

        }
    }
    public static class CommMsgInfo{
        public String content;
        public Long datetime;
        public Long fakeid;
        public Long id;
        public Integer status;
        public Integer type;
    }

}
