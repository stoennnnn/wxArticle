package com.zql.utils;

import java.util.Random;

/**
 * 随机数生成工具
 * Created by 26725 on 2019/2/19.
 */
public class RandomUtil {
    /**
     * 生成5000-1000的随机数
     * @return
     */
    public static Integer randomInt(){
        Random random = new Random();
        return random.nextInt(5000) + 5000;
    }
}
