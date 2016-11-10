package org.spirit.together.dictionary.translate.registry.support;

import org.spirit.together.dictionary.translate.registry.DictionaryRegistry;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.support.ExplicitRegistry.java
 * @Description   : qiudequan 具有明确意义的数据字典注册器
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午11:20:20 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public enum ExplicitDictionaryRegistry implements DictionaryRegistry {

  STATE("dict_state", "国家数据字典"),
  PROVINCE("dict_province", "省份数据字典"),
  CITY("dict_city", "城市数据字典"),
  DISTRICE("dict_district", "区域数据字典");

  private ExplicitDictionaryRegistry(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  private String code;

  private String desc;

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }

}
