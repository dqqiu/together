package org.spirit.together.dictionary.translate.resources.remoting;

import java.util.Map;

import org.spirit.together.dictionary.translate.meta.DictionaryMeta;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemoting.java
 * @Description   : qiudequan 字典远程访问接口
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午12:01:12 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public interface DictionaryRemotingAccessor {
  /**
   *  @Description	: qiudequan 远程请求
   *  @param          : @param reuqestMetas 远程请求元数据
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午12:00:49 
   *  @Author         : qiudequan
   */
  void remotingRequest(Map<String, DictionaryMeta> reuqestMetas);
  
  /**
   *  @Description	: qiudequan 设置唯一标识
   *  @param          : 
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午4:51:51 
   *  @Author         : qiudequan
   */
  String setKey(String key);
  
  /**
   *  @Description	: qiudequan 获取唯一标识
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午4:52:03 
   *  @Author         : qiudequan
   */
  String getKey();
}
