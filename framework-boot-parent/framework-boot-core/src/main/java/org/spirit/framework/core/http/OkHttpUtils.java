package org.spirit.framework.core.http;

import java.util.concurrent.TimeUnit;

import org.spirit.framework.core.http.callback.support.StringCallback;
import org.spirit.framework.core.http.request.DeleteRequest;
import org.spirit.framework.core.http.request.GetRequest;
import org.spirit.framework.core.http.request.PostRequest;
import org.spirit.framework.core.http.request.PutRequest;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.OkHttpUtils.java
 * @Description   : qiudequan OkHttp请求
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午1:31:17 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public class OkHttpUtils {

  private static final long DEFAULT_TIMEOUT = 5000;

  private OkHttpClient.Builder clientBuilder;
  
  public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
  public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");

  private OkHttpUtils() {
    clientBuilder = new OkHttpClient.Builder();
    clientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);   // 设置连接超时时间
    clientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);  // 设置读取超时时间
    clientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS); // 设置写入超时时间
  }

  private static class SingletonHolder {
    private static final OkHttpUtils instance = new OkHttpUtils();
  }

  public static OkHttpUtils getClient() {
    return SingletonHolder.instance;
  }
  
  public OkHttpClient.Builder getOkHttpClientBuilder(){
    return clientBuilder;
  }

  public static GetRequest get(String url) {
    return new GetRequest(url);
  }
  
  public static PostRequest post(String url) {
    return new PostRequest(url);
  }
  
  public static PutRequest put(String url) {
    return new PutRequest(url);
  }
  
  public static DeleteRequest delete(String url) {
    return new DeleteRequest(url);
  }
  
  public static void main(String[] args) {
    String url = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
    OkHttpUtils.get(url).
    addHeader("apikey", "ef514657814d70864d33f15cce359d51")
    .addParam("ip", "106.120.49.224").execute(new StringCallback(){ });
    
  }
}
