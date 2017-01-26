package org.spirit.together.dictionary.translate.registry.support;

import java.util.HashMap;
import java.util.Map;

import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourceMapping;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourcesRegistry;

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
public enum DictionaryResourcesRegistry implements DictionaryRemotingResourcesRegistry{
  
  PUBLIC("public", "公用数据字典", PublicRemotingRegistry.values()),
  EXPLICIT("explicit", "具有明确释义的数据字典", ExplicitRemotingRegistry.values());

  private DictionaryResourcesRegistry(String code, String desc, DictionaryRemotingResourceMapping[] mappings) {
    this.code = code;
    this.mappings = new HashMap<>();
    for (DictionaryRemotingResourceMapping mapping : mappings) {
      this.mappings.put(mapping.getRegistry().getCode(), mapping);
    }
    this.desc = desc;
  }
  
  public String code;
  
  public String desc;
  
  public Map<String, DictionaryRemotingResourceMapping> mappings;
  
  public String getCode() {
    return this.code;
  }
  
  public String getDesc() {
    return this.desc;
  }
  
}
