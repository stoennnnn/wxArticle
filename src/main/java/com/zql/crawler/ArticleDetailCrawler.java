package com.zql.crawler;

import com.zql.dataobject.WechatArticle;
import com.zql.dto.ArticleInfoDto;
import com.zql.dto.IPEntity;
import com.zql.repository.WechatArticleRepository;
import com.zql.utils.HTTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 获取文章具体信息
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
    @Autowired
    private WechatArticleRepository repository;
    public void getDetail(ArticleInfoDto articleInfoDto){
        IPEntity ipEntity = new IPEntity(ip, port, type);
        List<WechatArticle> articles = articleInfoDto.getArticles();
        if (!Optional.ofNullable(articles).isPresent()){
            log.error("【保存文章内容】 文章的url不存在");
            return;
        }
        for (WechatArticle article : articles) {
            Document doc = HTTPUtil.getResponseContent(article.getArticleContentUrl(), ipEntity);
            doc.removeAttr("script");
            int i = repository.saveContentById(doc.toString(), article.getArticleId());
        }
    }
}
