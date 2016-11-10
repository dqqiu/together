package org.spirit.together.dictionary.translate.registry;

import java.util.Map;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.DictionaryResourcesRegistry.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 下午1:17:50 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public enum DictionaryResourcesRegistry implements DictionaryRegistry{
  PUBLIC("public", "公用数据字典"),
  EXPLICIT("explicit", "具有明确释义的数据字典")
  ;

  private DictionaryResourcesRegistry(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
  private String code;
  
  private String desc;
  
  private Map<String, DictionaryRegistry> mappings;
  
  public String getCode() {
    return null;
  }
  
  public String getDesc() {
    return null;
  }
}
