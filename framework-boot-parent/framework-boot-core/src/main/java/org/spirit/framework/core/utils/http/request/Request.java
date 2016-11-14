package org.spirit.framework.core.utils.http.request;

import java.util.Map;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.request.Request.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午4:20:24 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public interface Request {
  public Request addParam(String key, String value);
  public Request addHeader(String key, String value);
  public Request removeHeader(String key);
  public Request removeAllHeaders();
  public Request addParam(Map<String, String> params);
}
