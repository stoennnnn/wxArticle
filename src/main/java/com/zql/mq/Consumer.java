package com.zql.mq;

import com.zql.repository.ArticleImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * 创建消费者
 * Created by 26725 on 2019/2/14.
 */
@Component
@Slf4j
public class Consumer {
    @Autowired
    private ArticleImageRepository imageRepository;
    @Value("${public.ip}")
    private String ip;
    @Value("${public.port}")
    private int port;
    @Value("${public.type}")
    private int type;
    @Value("${image.path}")
    private String path;

    /**
     *  * 通过消费者监听并发送邮件
     */
    @JmsListener(destination="imageUrlQueue")
    public void receiveInfo( String str) throws MessagingException {
//       // System.out.println(str);
//       // 先把json再次转为lsit
//        List<ImageUrlDto> imageUrlDtos = JsonUtil.toImageUrlDtos(str);
//        if (!Optional.ofNullable(imageUrlDtos).isPresent()){
//            log.error("[转换失败] json转list失败");
//            return;
//        }
//        for (ImageUrlDto imageUrlDto : imageUrlDtos) {
//            //间隔2秒下载一张
//            Thread thread = new Thread();
//            try {
//                thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //下载图片
//            IPEntity ipEntity = new IPEntity(ip, port, type);
//            String absolutelyPath =path + UUID.randomUUID().toString() + ".jpg";
//            String result = DownloadImageUtil.download(imageUrlDto.getImgOurl(), ipEntity, absolutelyPath);
//            if ("true".equals(result)){
//                log.info("[图片下载成功] 下载链接为：{}",imageUrlDto.getImgOurl());
//                //保存新的图片url
//                ArticleImage articleImage = new ArticleImage();
//                BeanUtils.copyProperties(imageUrlDto,articleImage);
//                articleImage.setImgNurl(absolutelyPath);
//                ArticleImage save = imageRepository.save(articleImage);
//                if (!Optional.ofNullable(save).isPresent()){
//                    log.error("[同步图片数据到数据库失败] 图片地址为：{}",articleImage.getImgOurl());
//                    continue;
//                }
//            }else{
//                log.error("[图片下载失败] 下载链接为：{}",imageUrlDto.getImgOurl());
//                continue;
//            }
//        }
//        log.info("[本次图片下载完成]");
    }
}
