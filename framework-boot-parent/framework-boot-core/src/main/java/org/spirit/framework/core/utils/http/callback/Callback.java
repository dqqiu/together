package org.spirit.framework.core.utils.http.callback;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.http.callback.Callback.java
 * @Description   : qiudequan 回调接口
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
  public void onSuccess(T result);
  
  /**
   *  @Description	: qiudequan 响应失败
   *  @param          : @param errMsg 错误信息
   *  @return 		: void
   *  @Creation Date  : 2016年11月14日 下午4:00:47 
   *  @Author         : qiudequan
   */
  public void onFailed(String errMsg);
}
