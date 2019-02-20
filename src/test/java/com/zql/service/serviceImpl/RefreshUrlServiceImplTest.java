package com.zql.service.serviceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-2-21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RefreshUrlServiceImplTest {
    @Autowired
    private  RefreshUrlServiceImpl refreshUrlServiceImol;
    @Test
    public void testUrl() throws Exception {
        String  str="https://mp.weixin.qq.com/s?timestamp=1550581403&src=3&ver=1&signature=DVAro*h1p-AHpIGeWmvl0haYEWvcTub3nmciWONRIU62IeU8TBfm0ZusyUZzdScmNWF418Xz1pg5gKuSXI7EDhfK5nT-fYvfGmrxH6xnBAiwJgoUgyuXaDDT5DEFpTClVk3JUBKf8zLSi23NR7F9EyQ5mWYME8gampn6io3ZabI=";
        String s2="https://mp.weixin.qq.com/s?timestamp=1550671410&src=3&ver=1&signature=ijI7RvQ97NOkLwdylHjqS-Y*xG9*vcGaXpSVDXvspvEiux2V-lmJQ*BFMi2yOrUH*yNOA6BjTPsQfJ-spiKMvtqWuOGOZCdxzSPhLFo9txAa0nXKe58z-IDtWG4YS8URn96wlHsL7DratqcXxil7eg5sDMX-W2kOKmI1SkbZakU=";
        String s = refreshUrlServiceImol.testUrl(s2);
        System.out.println(s);
    }

}