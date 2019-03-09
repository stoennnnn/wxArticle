package com.zql.test;

import com.zql.dto.ResultDto;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by 张启磊 on 2019-3-9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @org.junit.Test
    public  void  test(){
        ResultDto resultDto = new ResultDto();
        if (Optional.ofNullable(resultDto.getAccount()).isPresent()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
     }
}
