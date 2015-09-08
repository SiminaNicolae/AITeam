package com.fortech.aiteam.aiteam.model;

import com.fortech.aiteam.aiteam.utils.JsonDateDeserializer;
import com.fortech.aiteam.aiteam.utils.JsonDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.Date;

public class GsonObject {

    public String toJson() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateSerializer()).create();
        return gson.toJson(this);
    }

    public static <T> T fromJson(String json, Type gsonClass) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
        return gson.fromJson(json, gsonClass);
    }
}