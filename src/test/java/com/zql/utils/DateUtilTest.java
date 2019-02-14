package com.zql.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张启磊 on 2019-2-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DateUtilTest {
    @Test
    public void long2Date() throws Exception {
        //1549878282
        //2019-02-11 17:44:42
    //    Date date = DateUtil.Long2Date("yyyy-MM-dd HH:mm:ss",  1549878282000L);
    }

    @Test
    public void date2Long() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time_long = sdf.parse("2011-09-20 12:30:45").getTime();
        System.out.println(time_long);
        Date date = new Date(time_long);
        System.out.println(sdf.format(date));
        System.out.println(11);
    }
}