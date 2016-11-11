package org.spirit.together.dictionary.translate.test;

import org.spirit.together.dictionary.translate.DictionaryTranslator;
import org.spirit.together.dictionary.translate.ExampleClass;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.test.DictionaryTranslatorTest.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月11日 上午10:30:35 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月11日        create
 */
public class DictionaryTranslatorTest {
  public static void main(String[] args) {
    ExampleClass exampleClass = new ExampleClass();
    exampleClass.setDictSexCd("0");
    DictionaryTranslator.getInstance().translate(exampleClass);
  }
}
