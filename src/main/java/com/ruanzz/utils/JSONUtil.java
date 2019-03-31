package com.ruanzz.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author ZhenZhuo.Ruan
 */
public class JSONUtil {

  private static final String DATE_FORMAT_0 = "yyyy-MM-dd mm:HH:ss";
  private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat(DATE_FORMAT_0)
      .create();

  /**
   * 序列化
   *
   * @param object 序列化对象
   */
  public static String toJSON(Object object) {
    return gson.toJson(object);
  }

  /**
   * 反序列化
   *
   * @param json json字符串
   * @param clazz 对应class类型
   * @param <T> 对应Java类型
   */
  public static <T> T fromJSON(String json, Class<T> clazz) {
    return gson.fromJson(json, clazz);
  }


}
