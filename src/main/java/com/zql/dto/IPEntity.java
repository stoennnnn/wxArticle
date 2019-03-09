package com.zql.dto;

import lombok.Data;

/**
 * Created by 张启磊 on 2019-3-5.
 */
@Data
public class IPEntity {
    public static final int TYPE_HTTP = 0;
    public static final int TYPE_HTTPS = 1;
    private  String ip;
    private int port;
    //ip类型
    private int type;

    public IPEntity(String ip, Integer port, int type) {
        this.ip = ip;
        this.port = port;
        this.type = type;
    }

    public IPEntity() {
    }
}
