package com.zql.utils;

import com.zql.dto.IPEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 张启磊 on 2019-3-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadImage {
    @Test
    public void  download(){
//        https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWIaq3k3iaB0iaE4QDicOfhm46DulNKNeQicv4BEDpl2RdFgpaNy38adYcDuNTo5tgP98HFmwibiaP6ibkcvQ/640?wx_fmt=jpeg
//        https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJyzo8YOwAiabJtjNxfMvFjoXWTiaKZMaSIaoj2IqWN00l1QRF0k7GlGt4mmR7libS5HfXl2toXWszhQ/640?wx_fmt=png
//        https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJOZ0Z0ufASWoueJB1XpVJ20OWtBwJpY0ztzRQqstXBflFBebD6X8Q2Vh6O6CXZwHCPniaY5xhaxPQ/640?wx_fmt=png
        String url = "https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWIaq3k3iaB0iaE4QDicOfhm46DulNKNeQicv4BEDpl2RdFgpaNy38adYcDuNTo5tgP98HFmwibiaP6ibkcvQ/640?wx_fmt=jpeg";
        IPEntity ipEntity = new IPEntity("58.220.95.107", 8080, 1);
        InputStream ips = HTTPUtil.getResponseInputStream(url, ipEntity);
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
            e.printStackTrace();
        }

    }
}
