package org.spirit.together.dictionary.api.model;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.meta.DictionaryMeta.java
 * @Description   : qiudequan 字典元数据
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午10:42:01 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public interface DictBaseModel {
  
  /**
   *  @Description	: qiudequan 获取字典cd
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 上午11:43:07 
   *  @Author         : qiudequan
   */
  String getCd();
  
 /**
  *  @Description	: qiudequan 获取释义
  *  @param          : @return
  *  @return         : String
  *  @Creation Date  : 2016年12月11日 上午11:42:49 
  *  @Author         : qiudequan
  */
  String getDscp();
}
