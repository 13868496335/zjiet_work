package com.zjiet.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author: linlc
 * 2017/10/23 15:08
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
