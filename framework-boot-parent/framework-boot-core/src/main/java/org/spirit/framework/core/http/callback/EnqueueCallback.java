package org.spirit.framework.core.http.callback;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.http.EnqueueCallback.java
 * @Description   : qiudequan 异步回调接口(暂时未使用，空实现)
 * @Author        : qiudequan
 * @Creation Date : 2016年11月16日 上午9:51:14 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月16日        create
 */
public interface EnqueueCallback<T> extends Callback<T> {
  /**
   *  @Description	: qiudequan 检测进度
   *  @param          : @param currentSize 当前已上传/下载大小
   *  @param          : @param totalSize 当前上传/下载总大小
   *  @param          : @param progress 进度，百分比
   *  @param          : @param speed 上传/下载速度，单位：字节/秒
   *  @return 		: void
   *  @Creation Date  : 2016年11月16日 上午9:55:03 
   *  @Author         : qiudequan
   */
  public void onProgress(long currentSize, long totalSize, float progress, long speed );
}
