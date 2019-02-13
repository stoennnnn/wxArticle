package com.zql.utils;

import java.sql.Date;

/**
 * Created by 张启磊 on 2019-2-13.
 */
public class Long2DateUtil  {
    public static Date Long2Date(Long data){
       // SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(data);
        return  date;
    }
}
