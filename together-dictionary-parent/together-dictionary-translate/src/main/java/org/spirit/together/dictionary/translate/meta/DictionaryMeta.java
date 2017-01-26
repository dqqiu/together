package org.spirit.together.dictionary.translate.meta;

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
public interface DictionaryMeta {
  
  /**
   *  @Description	: qiudequan 获取字典Code
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 上午11:43:07 
   *  @Author         : qiudequan
   */
  String getCd();
  
  /**
   *  @Description	: qiudequan 获取欲翻译字段的值
   *  @param          : @return
   *  @return         : Object
   *  @Creation Date  : 2016年12月11日 下午8:11:39 
   *  @Author         : qiudequan
   */
  Object getCdValue();
  
 /**
  *  @Description	: qiudequan 获取释义
  *  @param          : @return
  *  @return         : String
  *  @Creation Date  : 2016年12月11日 上午11:42:49 
  *  @Author         : qiudequan
  */
  Object getDscp();
  
  /**
   *  @Description	: qiudequan 获取唯一标识
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 上午11:42:35 
   *  @Author         : qiudequan
   */
  String getKey();
}
