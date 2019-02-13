package com.zql.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 26725 on 2019/2/13.
 */
public class DateUtil {
    /**
     * Long转换为date并指定格式
     * @param data
     * @return
     */
    public static String Long2Date(String pattern , Long data) throws ParseException {
        //先转换成指定格式的String
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date(data);
        String format = sdf.format(date);
    }
    public static Long Date2Long(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat();
        long timeLong = sdf.parse(date).getTime();
        return timeLong;
    }
}
