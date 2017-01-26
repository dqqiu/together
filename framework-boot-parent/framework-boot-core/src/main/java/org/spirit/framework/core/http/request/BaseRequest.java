package org.spirit.framework.core.http.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.http.callback.Callback;
import org.spirit.framework.core.http.exceptions.DataConvertException;

import okhttp3.Call;
import okhttp3.RequestBody;
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
@SuppressWarnings({"unchecked", "hiding"})
public abstract class BaseRequest<T extends Request> implements Request {
  protected final Logger logger = LoggerFactory.getLogger(getClass());
  
  protected String url;
  
  protected Map<String, List<String>> params;
  
  protected Map<String, String> headers;
  
  protected RequestBody requestBody;
  
  public BaseRequest(String url) {
    this.url = url;
    this.params = new HashMap<String, List<String>>();
    this.headers = new HashMap<String, String>();
  }

  /**
   *  @Description	: qiudequan 创建okhttp3.Request对象，具体创建交由子类实现
   *  @param          : @return
   *  @return 		: okhttp3.Request
   *  @Creation Date  : 2016年11月14日 下午6:08:11 
   *  @Author         : qiudequan
   */
  public abstract okhttp3.Request createRequest(RequestBody requestBody);
  
  /**
   *  @Description  : qiudequan 创建请求体，具体创建交由子类实现
   *  @param          : @return
   *  @return       : okhttp3.Request
   *  @Creation Date  : 2016年11月14日 下午6:08:11 
   *  @Author         : qiudequan
   */
  public abstract okhttp3.RequestBody createRequestBody();

  public T addParam(String key, String value) {
    putToMap(key, value);
    return (T) this;
  }
  
  public T addParam(String key, List<String> values) {
    if(StringUtils.isEmpty(key) || CollectionUtils.isEmpty(values)) {
      return (T) this;
    }
    putParams(key, values);
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

  public T addParam(Map<String, List<String>> params) {
    if(params != null && !params.isEmpty()){
      this.params.putAll(params);
    }
    return (T) this;
  }
  
  public T setRequestBody(RequestBody requestBody) {
    this.requestBody = requestBody;
    return (T) this;
  }
  
  private void putParams(String key, List<String> values) {
    if (key != null && values != null && !values.isEmpty()) {
      for (String value : values) {
        putToMap(key, value);
      }
    }
  }
  
  private void putToMap(String key, String value) {
    if (key != null && value != null) {
      List<String> urlValues = params.get(key);
      if (urlValues == null) {
        urlValues = new ArrayList<>();
        params.put(key, urlValues);
      }
      urlValues.add(value);
    }
  }

  /**
   *  @Description	: qiudequan 执行同步请求
   *  @param          : @param callback
   *  @param          : @return
   *  @return 		: T
   *  @Creation Date  : 2016年11月16日 上午9:47:49 
   *  @Author         : qiudequan
   */
  public <T> T execute(Callback<T> callback){
    Response response = null;
    okhttp3.Request request = createRequest(createRequestBody());
    Call call = null;
    int code = -1;
    try {
      callback.onSendBefore(request);
      call = OkHttpUtils.getClient().getOkHttpClientBuilder().build().newCall(request);
      response = call.execute();
      code = response.code();
      if(response.isSuccessful()){
        T result = callback.dataConvert(response);
        callback.onSuccess(response, result);
        return result;
      } else {
        callback.onFailed(code, request, response, null);
      }
    } catch (IOException e) {
      callback.onFailed(code, request, response, e);
    } catch (DataConvertException e) {
      callback.onFailed(code, request, response, e);
    } catch (Exception e) {
      callback.onFailed(code, request, response, e);
    } finally {
      if(response != null){
        response.close();
      }
    }
    return null;
  }
  
}
