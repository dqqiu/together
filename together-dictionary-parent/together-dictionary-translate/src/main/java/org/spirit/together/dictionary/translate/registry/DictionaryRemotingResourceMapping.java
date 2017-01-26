package org.spirit.together.dictionary.translate.registry;

import org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourceMapping.java
 * @Description   : qiudequan 数据字典远程资源映射接口
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午5:22:39 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public interface DictionaryRemotingResourceMapping {
  /**
   *  @Description	: qiudequan 获取字典远程资源注册器
   *  @param          : @return
   *  @return         : DictionaryRemotingResourcesRegistry
   *  @Creation Date  : 2016年12月11日 下午5:22:56 
   *  @Author         : qiudequan
   */
  DictionaryRemotingResourcesRegistry getRegistry();
  
  /**
   *  @Description	: qiudequan 获取数据字典远程资源访问接口
   *  @param          : @return
   *  @return         : DictionaryRemotingAccessor
   *  @Creation Date  : 2016年12月11日 下午5:23:11 
   *  @Author         : qiudequan
   */
  DictionaryRemotingAccessor getRemotingAccessor();
}
