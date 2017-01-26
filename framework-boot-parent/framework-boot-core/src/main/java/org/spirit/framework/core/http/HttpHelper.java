package org.spirit.framework.core.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

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
public class HttpHelper {
  private static final Logger logger = LoggerFactory.getLogger(HttpHelper.class);
  /**
   *  @Description	: qiudequan 将传递的参数和url拼接成get请求所需要的完整url
   *  @param          : @param url
   *  @param          : @param params
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月14日 下午6:02:44 
   *  @Author         : qiudequan
   */
  public static String createUrlParams(String url, Map<String, List<String>> params){
    try {
      StringBuilder sb = new StringBuilder();
      sb.append(url);
      if (url.indexOf('&') > 0 || url.indexOf('?') > 0)
        sb.append("&");
      else
        sb.append("?");
      for (Map.Entry<String, List<String>> urlParams : params.entrySet()) {
        List<String> urlValues = urlParams.getValue();
        for (String value : urlValues) {
          // 进行 utf-8 编码,防止中文乱码
          String urlValue = URLEncoder.encode(value, "UTF-8");
          sb.append(urlParams.getKey()).append("=").append(urlValue).append("&");
        }
      }
      sb.deleteCharAt(sb.length() - 1);
      return sb.toString();
    } catch (UnsupportedEncodingException e) {
      logger.error("Unsupported encoding", e);
    }
    return url;
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

  public static RequestBody createRequestBody(Map<String, List<String>> params){
    FormBody.Builder bodyBuilder = new FormBody.Builder();
    for (String key : params.keySet()) {
      List<String> urlValues = params.get(key);
      for (String value : urlValues) {
        bodyBuilder.add(key, value);
      }
    }
    return bodyBuilder.build();
  }
}
