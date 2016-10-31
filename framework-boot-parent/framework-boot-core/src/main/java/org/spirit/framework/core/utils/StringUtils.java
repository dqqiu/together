package org.spirit.framework.core.utils;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.StringUtils.java
 * @Description   : qiudequan 字符串工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月13日 下午5:53:46 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月13日        create
 */
public class StringUtils extends org.springframework.util.StringUtils {
  
  private static final char UNDERLINE = '_';
  
  /**
   *  @Description	: qiudequan 字符串拼接，适用于较短的字符串拼接
   *  @return         : String
   *  @Creation Date  : 2016年10月13日 下午5:59:22 
   *  @Author         : qiudequan
   */
  public static String append(String... sources) {
    if(sources == null || sources.length == 0){
      return "";
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < sources.length; i++) {
      builder.append(sources[i]);
    }
    return builder.toString();
  }
  
  /**
   *  @Description  : qiudequan 以"_"隔开的字符串转换为驼峰命名
   *  @param          : @param source 源字符串
   *  @param          : @return
   *  @return       : String
   *  @Creation Date  : 2016年10月31日 下午1:13:45 
   *  @Author         : qiudequan
   */
  public static String camel(String source){
    if(!hasText(source)){
      return "";
    }
    int length = source.length();
    StringBuilder stringBuilder = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      char c = source.charAt(i);
      if(c == UNDERLINE){
        if(++i < length){
          stringBuilder.append(Character.toUpperCase(source.charAt(i)));
        }
      } else {
        stringBuilder.append(c);
      }
    }
    return stringBuilder.toString();
  }
  
  /**
   *  @Description	: qiudequan 驼峰命名转换为以"_"隔开的命名
   *  @param          : @param source 源字符串
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年10月31日 下午1:20:38 
   *  @Author         : qiudequan
   */
  public static String camelToUnderline(String source){
    if(!hasText(source)){
      return "";
    }
    int length = source.length();
    StringBuilder stringBuilder = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      char c = source.charAt(i);
      if(Character.isUpperCase(c)){
        stringBuilder.append(UNDERLINE);
        stringBuilder.append(Character.toLowerCase(c));
      } else {
        stringBuilder.append(c);
      }
    }
    return stringBuilder.toString();
  }
  
  /**
   *  @Description	: qiudequan 首字母大写
   *  @param          : @param source
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年10月31日 下午1:35:41 
   *  @Author         : qiudequan
   */
  public static String firstLetterToUpper(String source){
    if(!hasText(source)){
      return "";
    }
    char[] chars = source.toCharArray();
    chars[0] -= 32;
    return String.valueOf(chars);
  }
  public static void main(String[] args) {
    String result = camel("user_code");
    System.out.println(result);
    String underlineResult = camelToUnderline(result);
    System.out.println(underlineResult);
    System.out.println(firstLetterToUpper("userCase"));
  }
}
