package org.spirit.framework.core.utils.http.request;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.utils.http.callback.Callback;

import okhttp3.Response;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.request.BaseRequest.java
 * @Description   : qiudequan 请求基类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午1:55:56 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public abstract class BaseRequest<T extends Request> implements Request {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  protected String url;
  
  protected Map<String, String> params;
  
  protected Map<String, String> headers;
  
  
  
  public BaseRequest(String url) {
    this.url = url;
    this.params = new HashMap<String, String>();
    this.headers = new HashMap<String, String>();
  }

  /**
   *  @Description	: qiudequan 创建okhttp3.Request对象，具体创建交由子类实现
   *  @param          : @return
   *  @return 		: okhttp3.Request
   *  @Creation Date  : 2016年11月14日 下午6:08:11 
   *  @Author         : qiudequan
   */
  public abstract okhttp3.Request createRequest();

  public T addParam(String key, String value) {
    this.params.put(key, value);
    return (T) this;
  }

  public T addHeader(String key, String value) {
    this.headers.put(key, value);
    return (T) this;
  }

  public T removeHeader(String key) {
    this.headers.remove(key);
    return (T) this;
  }

  public T removeAllHeaders() {
    this.headers.clear();
    return (T) this;
  }

  public T addParam(Map<String, String> params) {
    if(params != null && !params.isEmpty()){
      this.params.putAll(params);
    }
    return (T) this;
  }
  
  public T execute(Callback<T> callback){
    Response response = null;
    return null;
  }
  
}
