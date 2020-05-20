package com.zbq.websocket.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ysz
 * @className JsonUtil
 * @description json转换工具
 * @date Created in 2018/7/5 22:56
 */
public class JsonUtils {

    private JsonUtils() { }

    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
    * @description  object转换为json字符串
     * @author ysz
     * @date 2018/7/5 22:59
     * @param
     * @return
     *
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }


    /**
    * @description json字符串转为Bean
     * @author ysz
     * @date 2018/7/5 23:00
     * @param
     * @return
     *
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
    * @description json字符串转成list
     * @author ysz
     * @date 2018/7/5 23:00
     * @param
     * @return
     *
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(gsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry){
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
    * @description json字符串转成list中含有map的
     * @author ysz
     * @date 2018/7/5 23:01
     * @param
     * @return
     *
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
    * @description json字符串转成map
     * @author ysz
     * @date 2018/7/5 23:01
     * @param
     * @return
     *
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * List<T> 转 json 保存到数据库
     * zjx  05.18
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     *     zjx  05.18
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }
}
