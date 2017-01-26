package org.spirit.together.dictionary.translate;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.DictionaryTranslator.java
 * @Description   : qiudequan 字典翻译器
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


  /**
   *  @Description	: qiudequan 翻译
   *  @param          : @param source 存在有需要翻译字段的对象
   *  @return         : void
   *  @Creation Date  : 2016年12月10日 下午8:11:31 
   *  @Author         : qiudequan
   */
  public void translate(Object source) {
    
  }
  
  
  public void isExplicit() {
    
  }
}
