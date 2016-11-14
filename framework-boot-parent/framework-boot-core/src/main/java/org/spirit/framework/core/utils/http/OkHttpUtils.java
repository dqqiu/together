package org.spirit.framework.core.utils.http;

import java.util.concurrent.TimeUnit;

import org.spirit.framework.core.utils.http.request.GetRequest;

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

  private static OkHttpClient.Builder clientBuilder;

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

  public static GetRequest get(String url) {
    return new GetRequest(url);
  }
}
