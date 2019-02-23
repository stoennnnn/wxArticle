package com.zql.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by 张启磊 on 2019-2-23.
 */
@Data
public  class MultiAppMsgItemInfo{
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