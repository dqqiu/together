package org.spirit.together.dictionary.translate.registry.support;

import org.spirit.together.dictionary.translate.registry.DictionaryRegistry;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.support.PublicRegistry.java
 * @Description   : qiudequan 公共数据字典注册器
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午11:17:38 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public enum PublicDictionaryRegistry implements DictionaryRegistry {
  
  DATA("dict_data", "公共数据字典");
  
  private PublicDictionaryRegistry(String code, String desc) {
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
