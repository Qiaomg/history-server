package net.shopin.history.utils;

import com.google.gson.Gson;

/**
 * @title: GsonUtil
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/12 9:54
 * @version: V1.0
 */
public class GsonUtil {
    public static Gson gson = new Gson();

    /**
     * @param jsonString json字符串
     * @param clszz  要转换的类
     * @param <T>  返回要转换的类
     * @return
     */
    public static <T> T getClass(String jsonString, Class<T> clszz) {
        T t = null;
        try {
            t = gson.fromJson(jsonString, clszz);
        } catch (Exception e) {
        }
        return t;
    }

    /**
     * Object 转jsonString
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj){
        return gson.toJson(obj);
    }
}
