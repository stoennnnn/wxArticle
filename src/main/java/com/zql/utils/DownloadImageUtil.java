package com.zql.utils;

import com.zql.dto.IPEntity;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by 26725 on 2019/3/13.
 */
@Slf4j
public class DownloadImageUtil {
    public static String  download(String url,IPEntity ipEntity){
        InputStream ips = HTTPUtil.getResponseInputStream(url, ipEntity);
        if(!Optional.ofNullable(ips).isPresent()){
            return "false";
        }
        //一次读取的长度
        byte[] data= new byte[1024];
        int len=0;
        FileOutputStream fos = null;
        try {
            //创建输出流
            fos = new FileOutputStream("C:\\Users\\38213\\Desktop\\wx\\image\\1.jpg");
            //读到文件末尾返回-1，表示已经读完
            while ((len=ips.read(data))!=-1){
                fos.write(data,0,len);
            }
            ips.close();
            fos.close();
        } catch (IOException e) {
            log.error("【图片下载】 下载图片失败");
            e.printStackTrace();
        }
        return "true";
    }
}
