package org.spirit.together.dictionary.translate;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.DictionaryTranslator.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午10:50:59 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public class DictionaryTranslator {
  private static final DictionaryTranslator instance = new DictionaryTranslator();
  
  private DictionaryTranslator() {}

  public static DictionaryTranslator getInstance() {
    return instance;
  }



  public void translate(Object source) {

  }
}
