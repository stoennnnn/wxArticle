package com.zql.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonPrimitive;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by 26725 on 2019/2/13.
 */
public class DateSerializeUtil extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    }

}
