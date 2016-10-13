package org.spirit.framework.core.utils;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.StringUtils.java
 * @Description   : TODO qiudequan 字符串工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月13日 下午5:53:46 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月13日        create
 */
public class StringUtils extends org.springframework.util.StringUtils {
  
  /**
   *  @Description	: TODO qiudequan 字符串拼接，适用于较短的字符串拼接
   *  @return         : String
   *  @Creation Date  : 2016年10月13日 下午5:59:22 
   *  @Author         : qiudequan
   */
  public String append(String... sources) {
    if(sources == null || sources.length == 0){
      return "";
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < sources.length; i++) {
      builder.append(sources[i]);
    }
    return builder.toString();
  }
}
