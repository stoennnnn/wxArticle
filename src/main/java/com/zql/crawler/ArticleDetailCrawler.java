package com.zql.crawler;

import com.zql.dataobject.WechatArticle;
import com.zql.dto.ArticleInfoDto;
import com.zql.dto.IPEntity;
import com.zql.repository.WechatArticleRepository;
import com.zql.utils.HTTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 获取文章具体信息，
 * Created by 张启磊 on 2019-3-12.
 */
@Component
@Slf4j
public class ArticleDetailCrawler {
    @Value("${public.ip}")
    private String ip;
    @Value("${public.port}")
    private int port;
    @Value("${public.type}")
    private int type;

    /**
     * 根据文章url获取具体内容
     * @param article
     * @return
     */
    public Document getDetail(WechatArticle article) {
        IPEntity ipEntity = new IPEntity(ip, port, type);
        if (!Optional.ofNullable(article).isPresent()) {
            log.error("【保存文章内容】 文章的url不存在");
            return new Document(null);
        }
        Document doc = HTTPUtil.getResponseContent(article.getArticleContentUrl(), ipEntity);
        //把doc的<script>标签全部去掉
        doc.getElementsByTag("script").remove();
        return doc;
    }
}
