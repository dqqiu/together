package org.spirit.framework.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.DateUtils.java
 * @Description   : qiudequan 日期工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月29日 下午3:47:32 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月29日        create
 */
public class DateUtils {
  private static final String DATE = "yyyy-MM-dd";
  private static final String DATE_HH_MM = "yyyy-MM-dd HH:mm";
  private static final String DATE_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
  
  private static Map<String, DateFormat> dateFormats = new HashMap<>();
  
  static {
    dateFormats.put(DATE, new SimpleDateFormat(DATE));       
    dateFormats.put(DATE_HH_MM, new SimpleDateFormat(DATE_HH_MM));       
    dateFormats.put(DATE_HH_MM_SS, new SimpleDateFormat(DATE_HH_MM_SS));       
  }
  
  /**
   *  @Description	: qiudequan 获取当前时间的毫秒级时间戳
   *  @param          : @return
   *  @return 		: long
   *  @Creation Date  : 2016年11月29日 下午4:03:00 
   *  @Author         : qiudequan
   */
  public static long getCurrentTime() {
    return System.currentTimeMillis();
  }
  
  /**
   *  @Description	: qiudequan 获取当前时间
   *  @param          : @return
   *  @return 		: Date
   *  @Creation Date  : 2016年11月29日 下午4:03:16 
   *  @Author         : qiudequan
   */
  public static Date getCurrentDate() {
    return new Date();
  }
  
  /**
   *  @Description	: qiudequan 获取当前时间的格式化时间字符串，默认格式yyyy-MM-dd HH:mm:ss
   *  @param          : @param pattern 日期格式，如传入错误或没有传入，默认为yyyy-MM-dd HH:mm:ss格式
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午4:06:13 
   *  @Author         : qiudequan
   */
  public static String getCurrentFormatTime(String pattern){
    if(StringUtils.isEmpty(pattern) || !dateFormats.containsKey(pattern)){
      pattern = DATE_HH_MM_SS;
    }
    return dateFormats.get(pattern).format(new Date());
  }
  
  /**
   *  @Description	: qiudequan 获取指定格式的日期字符串
   *  @param          : @param date 日期时间
   *  @param          : @param pattern 日期格式，如传入错误或没有传入，默认为yyyy-MM-dd HH:mm:ss格式
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午4:01:34 
   *  @Author         : qiudequan
   */
  public static String getFormatTime(Date date, String pattern) {
    if(StringUtils.isEmpty(pattern) || !dateFormats.containsKey(pattern)){
      pattern = DATE_HH_MM_SS;
    }
    return dateFormats.get(pattern).format(date);
  }
  
  /**
   *  @Description	: qiudequan 日期字符串转日期
   *  @param          : @param dateStr 日期字符串
   *  @param          : @param pattern 日期格式
   *  @param          : @return
   *  @param          : @throws ParseException
   *  @return 		: Date
   *  @Creation Date  : 2016年11月29日 下午4:10:25 
   *  @Author         : qiudequan
   */
  public static Date parseDate(String dateStr, String pattern) throws ParseException {
    if(StringUtils.isEmpty(dateStr)){
      return null;
    }
    
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    return dateFormat.parse(dateStr);
  }
}
