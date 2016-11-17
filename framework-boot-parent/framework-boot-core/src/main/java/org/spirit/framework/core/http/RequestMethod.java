package org.spirit.framework.core.http;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.RequestType.java
 * @Description   : qiudequan 请求方法类型枚举
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午4:06:19 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public enum RequestMethod {
  GET("GET"), POST("POST"), PUT("PUT"), DELETE("DELETE");
  
  private String code;

  private RequestMethod(String code) {
    this.code = code;
  }
  
  public String getCode(){
    return this.code;
  }
  
}
