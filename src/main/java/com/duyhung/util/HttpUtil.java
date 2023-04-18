package com.duyhung.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }
    public <T> T toModel(Class<T> tClass){
        try{
            return new ObjectMapper().readValue(value,tClass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static HttpUtil of(BufferedReader reader){
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while(true){
            try {
                if ((line = reader.readLine()) == null) break;
                stringBuilder.append(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new HttpUtil(stringBuilder.toString());
    }
}
