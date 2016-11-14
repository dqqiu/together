package org.spirit.framework.core.utils.http;

import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.URLHelper.java
 * @Description   : qiudequan URL辅助类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午5:59:03 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public class URLHelper {
  /**
   *  @Description	: qiudequan 将传递的参数和url拼接成get请求所需要的完整url
   *  @param          : @param url
   *  @param          : @param params
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月14日 下午6:02:44 
   *  @Author         : qiudequan
   */
  public static String createUrlParams(String url, Map<String, String> params){
    StringBuilder urlBuilder = new StringBuilder(url);
    if(params != null && !params.isEmpty()){
      urlBuilder.append("?");
      int index = 0;
      for (Map.Entry<String, String> entry : params.entrySet()) {
        if(index != 0){
          urlBuilder.append("&");
        }
        urlBuilder.append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    return urlBuilder.toString();
  }
  
  /**
   *  @Description	: qiudequan 由Headers头信息创建Request.Builder
   *  @param          : @param headers
   *  @param          : @return
   *  @return 		: Request.Builder
   *  @Creation Date  : 2016年11月14日 下午6:04:54 
   *  @Author         : qiudequan
   */
  public static Request.Builder createRequestFromHeaders(Map<String, String> headers){
    Request.Builder requestBuilder = new Request.Builder();
    if(headers != null && !headers.isEmpty()){
      Headers.Builder headersBuilder = new Headers.Builder();
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        headersBuilder.add(entry.getKey(), entry.getValue());
      }
      requestBuilder.headers(headersBuilder.build());
    }
    return requestBuilder;
  }
}
