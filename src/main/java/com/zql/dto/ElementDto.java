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
        private Integer audioFileid;
        @SerializedName("author")
        public String author;
        private String content;
        @SerializedName("content_url")
        private String contentUrl;
        @SerializedName("copyright_stat")
        private Integer copyrightStat;
        private String cover;
        @SerializedName("del_flag")
        private Integer delFlag;
        private String digest;
        private Integer duration;
        private Integer fileid;
        @SerializedName("is_multi")
        private Integer isMulti;
        @SerializedName("item_show_type")
        private Integer itemShowType;
        @SerializedName("malicious_content_type")
        private Integer maliciousContentType;
        @SerializedName("malicious_title_reason_id")
        private Integer maliciousTitleReasonId;
        @SerializedName("multi_app_msg_item_list")
        public List<MultiAppMsgItemInfo> multiAppMsgItemList;
        @SerializedName("play_url")
        private String playUrl;
        @SerializedName("source_url")
        private String sourceUrl;
        private Integer subtype;
        private String  title;

        public static class MultiAppMsgItemInfo{
            @SerializedName("audio_fileid")
            private Integer audioFileid;
            private String author;
            private String content;
            @SerializedName("content_url")
            private String contentUrl;
            @SerializedName("copyright_stat")
            private Integer copyrightStat;
            private String cover;
            @SerializedName("del_flag")
            private Integer delFlag;
            private String digest;
            private Integer duration;
            private Integer fileid;
            @SerializedName("item_show_type")
            private Integer itemShowType;
            @SerializedName("malicious_content_type")
            private Integer maliciousContentType;
            @SerializedName("malicious_title_reason_id")
            private Integer maliciousTitleReasonId;
            @SerializedName("play_url")
            private String playUrl;
            @SerializedName("source_url")
            private String sourceUrl;
            private String  title;

        }
    }
    public static class CommMsgInfo{
        private String content;
        private Integer datetime;
        private Integer id;
        private Integer status;
        private Integer type;
    }

}
