package com.zql.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zql.dto.AppMsgExtInfo;
import com.zql.dto.ResultBean;
import lombok.extern.slf4j.Slf4j;

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
     * json转List
     * @param str
     * @return
     */
    public static List<AppMsgExtInfo> toList(String str) {
//        //先转JsonObject
//        JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();
//        Gson gson = new Gson();
//        ArrayList<AppMsgExtInfo> appMsgExtInfoList = new ArrayList<>();
//        //再转JsonArray 加上数据头
//        JsonArray jsonArray = jsonObject.getAsJsonArray("list");
////        //循环遍历
//        for (JsonElement AppMsgExtInfo : jsonArray) {
//            //通过反射 得到UserBean.class
//            AppMsgExtInfo appMsgExtInfo = gson.fromJson(AppMsgExtInfo, new TypeToken<AppMsgExtInfo>() {}.getType());
//            appMsgExtInfoList.add(appMsgExtInfo);
//        }

        //GSON直接解析成对象
        ResultBean resultBean = new Gson().fromJson(str,ResultBean.class);
        //对象中拿到集合
        List<AppMsgExtInfo> appMsgExtInfoList = resultBean.getList();
        return appMsgExtInfoList;
    }
}
