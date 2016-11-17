package org.spirit.framework.core.http.callback;

import okhttp3.Request;
import okhttp3.Response;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.callback.Callback.java
 * @Description   : qiudequan 请求回调接口
 * @Author        : qiudequan
 * @Creation Date : 2016年11月14日 下午3:53:20 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月14日        create
 */
public interface Callback<T> {
  /**
   *  @Description	: qiudequan 响应成功
   *  @param          : @param result 响应结果
   *  @return 		: void
   *  @Creation Date  : 2016年11月14日 下午4:00:35 
   *  @Author         : qiudequan
   */
  public void onSuccess(Response response, T result);
  
  /**
   *  @Description	: qiudequan 响应失败
   *  @param          : @param errMsg 错误信息
   *  @return 		: void
   *  @Creation Date  : 2016年11月14日 下午4:00:47 
   *  @Author         : qiudequan
   */
  public void onFailed(int errorCode, Request request, Response response, Exception e);
  
  /**
   *  @Description	: qiudequan 请求发送前的处理
   *  @param          : @param request
   *  @return 		: void
   *  @Creation Date  : 2016年11月15日 下午1:33:17 
   *  @Author         : qiudequan
   */
  public void onSendBefore(Request request);
  
  /**
   *  @Description	: qiudequan 数据转换
   *  @param          : @param response
   *  @param          : @return
   *  @return 		: T
   *  @Creation Date  : 2016年11月15日 下午1:34:35 
   *  @Author         : qiudequan
   */
  T dataConvert(Response response);
}
