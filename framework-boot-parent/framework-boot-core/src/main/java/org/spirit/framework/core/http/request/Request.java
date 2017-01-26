package org.spirit.framework.core.http.request;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;

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
  /**
   *  @Description	: qiudequan 添加请求参数
   *  @param          : @param key
   *  @param          : @param value
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:04:57 
   *  @Author         : qiudequan
   */
  public Request addParam(String key, String value);
  
  /**
   *  @Description	: qiudequan 添加指定的请求头信息
   *  @param          : @param key
   *  @param          : @param value
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:05:13 
   *  @Author         : qiudequan
   */
  public Request addHeader(String key, String value);
  
  /**
   *  @Description	: qiudequan 移除指定的请求头信息
   *  @param          : @param key
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:05:29 
   *  @Author         : qiudequan
   */
  public Request removeHeader(String key);
  
  /**
   *  @Description	: qiudequan 移除全部请求头信息
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:05:46 
   *  @Author         : qiudequan
   */
  public Request removeAllHeaders();
  
  /**
   *  @Description	: qiudequan 添加指定的请求头信息(批量)
   *  @param          : @param params
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:06:10 
   *  @Author         : qiudequan
   */
  public Request addParam(Map<String, List<String>> params);
  
  /**
   *  @Description	: qiudequan 设置请求体
   *  @param          : @param requestBody
   *  @param          : @return
   *  @return 		: Request
   *  @Creation Date  : 2016年11月16日 上午10:06:29 
   *  @Author         : qiudequan
   */
  public Request setRequestBody(RequestBody requestBody);
}
