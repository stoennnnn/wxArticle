package com.zql.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zql.dto.ElementDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启磊 on 2019-2-11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonUtilTest {
    @Test
    public void toList() {
        String value ="[{\n" +
                "\t\"app_msg_ext_info\": {\n" +
                "\t\t\"author\": \"222\",\n" +
                "\t\t\"multi_app_msg_item_list\": [{\n" +
                "\t\t\t\"audio_fileid\": 0\n" +
                "\t\t}]\n" +
                "\t},\n" +
                "\t\"comm_msg_info\": {\n" +
                "\t\t\"content\": \"11111\"\n" +
                "\t}\n" +
                "}]";
        Gson gson = new Gson();
  //      ElementDto[] elementDtos1 = gson.fromJson(value, ElementDto[].class);
        List<ElementDto> elementDtos = new ArrayList<ElementDto>();
        Type type = new TypeToken<List<ElementDto>>() {}.getType();
        elementDtos= gson.fromJson(value, type);
    }

}