package com.zql.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zql.dto.ArticleInfoDto;
import com.zql.dto.ElementDto;
import com.zql.dto.ImageUrlDto;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *  json转换类
 * Created by 张启磊 on 2019-2-11.
 */
@Slf4j
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    /**
     * json转ListElementDto
     *
     * @param str
     * @return
     */
    public static List<ElementDto> toListElementDto(String str) {
        Gson gson = new Gson();
        List<ElementDto> elementDtos = new ArrayList<>();
        Type type = new TypeToken<List<ElementDto>>() {}.getType();
        elementDtos= gson.fromJson(str, type);
        return elementDtos;
    }

    /**
     * json转ArticleInfoBean
     * @param str
     * @return
     */
    public static List<ArticleInfoDto> toArticleInfoBeans (String str){
        Gson gson = new Gson();
        List<ArticleInfoDto> articleInfoDtos = new ArrayList<>();
        Type type = new TypeToken<List<ArticleInfoDto>>() {}.getType();
        articleInfoDtos= gson.fromJson(str, type);
        return articleInfoDtos;
    }

    /**
     * json转list
     * @param str
     * @return
     */
    public static List<ImageUrlDto> toImageUrlDtos (String str){
        Gson gson = new Gson();
        List<ImageUrlDto> imageUrlDtos = new ArrayList<>();
        Type type = new TypeToken<List<ImageUrlDto>>() {}.getType();
        imageUrlDtos= gson.fromJson(str, type);
        return imageUrlDtos;
    }

}
