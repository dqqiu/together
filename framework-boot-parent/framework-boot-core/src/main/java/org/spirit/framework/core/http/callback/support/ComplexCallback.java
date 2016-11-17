package org.spirit.framework.core.http.callback.support;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.http.callback.Callback;
import org.spirit.framework.core.http.exceptions.DataConvertException;
import org.spirit.framework.core.utils.GsonDateAdapter;
import org.spirit.framework.core.utils.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;

import okhttp3.Request;
import okhttp3.Response;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.http.callback.support.ComplexCallback.java
 * @Description   : qiudequan 复杂类型回调
 * @Author        : qiudequan
 * @Creation Date : 2016年11月15日 下午2:16:10 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月15日        create
 */
@SuppressWarnings("unchecked")
public class ComplexCallback<T> implements Callback<T> {
  
  final Logger logger = LoggerFactory.getLogger(getClass());
  
  protected final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateAdapter()).create();
  /**
   * type用于方便JSON的解析
   */
  protected Type mType;

  /**
   * @param subclass
   * @return
   */
  static Type getSuperclassTypeParameter(Class<?> subclass) {
    Type superclass = subclass.getGenericSuperclass();
    if (superclass instanceof Class) {
      throw new RuntimeException("Missing type parameter.");
    }
    ParameterizedType parameterized = (ParameterizedType) superclass;
    return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
  }

  /**
   * 构造的时候获得type的class
   */
  public ComplexCallback() {
    mType = getSuperclassTypeParameter(getClass());
  }

  public void onSuccess(Response response, T result) {
    logger.info("Request success.ResponseCode : [{}], Message : [{}]", response.code(), response.message());
  }

  public void onFailed(int errorCode, Request request, Response response, Exception e) {
    logger.error("Request failed.URL : [{}], ResponseCode : [{}], Message : [{}]", request.url().toString(), response.code(), response.message(), e);
  }

  public void onSendBefore(Request request) {
    logger.info("Request : [{}]", request);
  }

  public T dataConvert(Response response) {
    try {
      String responseBody = response.body().string();
      if(StringUtils.isEmpty(responseBody)){
        return null;
      }
      return (T) gson.fromJson(responseBody, mType);
    } catch (IOException e) {
      logger.error("Data convert failed.", e);
      throw new DataConvertException("结果集转换异常", e);
    }
    
  }

}
