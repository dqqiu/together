package org.spirit.framework.core.http.callback.support;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.http.callback.Callback;
import org.spirit.framework.core.http.exceptions.DataConvertException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.callback.support.StringCallback.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月15日 下午1:37:57 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月15日        create
 */
public class StringCallback implements Callback<String> {

  final Logger logger = LoggerFactory.getLogger(getClass());
  
  public void onSuccess(Response response, String result) {
    logger.info("Request success.ResponseCode : [{}], Message : [{}]", response.code(), response.message());
  }

  public void onFailed(int errorCode, Request request, Response response, Exception e) {
    logger.error("Request failed.URL : [{}], ResponseCode : [{}], Message : [{}]", request.url().toString(), response.code(), response.message(), e);
  }

  public void onSendBefore(Request request) {
    logger.info("Request : [{}]", request);
  }

  public String dataConvert(Response response) {
    try {
      return response.body().string();
    } catch (IOException e) {
      logger.error("Data convert failed.", e);
      throw new DataConvertException("结果集转换异常", e);
    }
  }

}
