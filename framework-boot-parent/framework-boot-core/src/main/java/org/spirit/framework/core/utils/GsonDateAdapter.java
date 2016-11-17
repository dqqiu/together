package org.spirit.framework.core.utils;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.GsonDateAdapter.java
 * @Description   : qiudequan Gson序列化日期格式(时区：东八区)适配器
 * @Author        : qiudequan
 * @Creation Date : 2016年11月17日 上午11:05:54 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月17日        create
 */
public class GsonDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

  /**
   * 反序列化
   */
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    try {
      String s = json.getAsString();
      final DateFormat dateFormat = getFormat(s);

      return dateFormat.parse(s);
    } catch (ParseException e) {
      throw new JsonParseException(e);
    }

  }

  /**
   * 序列化
   */
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    final DateFormat dateFormat = getFormat();
    return new JsonPrimitive(dateFormat.format(src));
  }

  private DateFormat getFormat(String s) {
    DateFormat dateFormat;
    String format = null;
    if (s == null) {
      return null;
    } else if (s.length() == 10) {
      format = "yyyy-MM-dd";
    } else if (s.length() == 19) {
      format = "yyyy-MM-dd' 'HH:mm:ss";
    } else if (s.length() == 23) {
      format = "yyyy-MM-dd' 'HH:mm:ss.SSS";
    } else {
      throw new JsonParseException("Date format error:" + s);
    }

    dateFormat = new SimpleDateFormat(format);
    // 设置时区为东八区
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    return dateFormat;
  }

  /**
   *  @Description	: qiudequan 日期格式化
   *  @param          : @return
   *  @return 		: DateFormat
   *  @Creation Date  : 2016年11月17日 上午11:08:09 
   *  @Author         : qiudequan
   */
  private DateFormat getFormat() {
    String format = "yyyy-MM-dd' 'HH:mm:ss";
    DateFormat dateFormat = new SimpleDateFormat(format);
    // 设置时区为东八区
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    return dateFormat;
  }

}
