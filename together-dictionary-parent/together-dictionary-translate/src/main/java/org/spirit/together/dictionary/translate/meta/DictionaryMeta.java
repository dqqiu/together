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
public class DictionaryMeta {
  private String name;
  private String key;
  private Object value;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  
}
