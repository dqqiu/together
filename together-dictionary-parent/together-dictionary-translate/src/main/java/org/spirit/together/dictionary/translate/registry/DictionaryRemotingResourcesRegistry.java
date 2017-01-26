package org.spirit.together.dictionary.translate.registry;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourcesRegistry.java
 * @Description   : qiudequan 远程资源注册接口
 * @Author        : qiudequan
 * @Creation Date : 2016年12月10日 下午8:34:03 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月10日        create
 */
public interface DictionaryRemotingResourcesRegistry {
  /**
   *  @Description	: qiudequan 获取Code
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月10日 下午8:38:25 
   *  @Author         : qiudequan
   */
  String getCode();
  
  /**
   *  @Description	: qiudequan 获取描述
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月10日 下午8:38:36 
   *  @Author         : qiudequan
   */
  String getDesc();
}
