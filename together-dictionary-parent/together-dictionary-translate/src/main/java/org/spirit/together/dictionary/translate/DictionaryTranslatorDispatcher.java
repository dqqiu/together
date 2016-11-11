package org.spirit.together.dictionary.translate;

import org.spirit.together.dictionary.translate.analyze.AnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.analyze.support.ExplicitAnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.analyze.support.PublicAnalyzeSourceProperties;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.DictionaryTranslatorDispatcher.java
 * @Description   : qiudequan 翻译请求分发器
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 下午5:37:20 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public class DictionaryTranslatorDispatcher {
  /**
   *  @Description	: qiudequan 分发公共字典数据翻译请求
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月11日 上午9:53:05 
   *  @Author         : qiudequan
   */
  public void publicDictionaryTranslate(Object source) {
    new PublicAnalyzeSourceProperties().analyze(source);
  }
  
  /**
   *  @Description	: qiudequan 分发具有明确释义的字典数据翻译请求
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月11日 上午10:37:34 
   *  @Author         : qiudequan
   */
  public void explicitDictionaryTranslate(Object source) {
    new ExplicitAnalyzeSourceProperties().analyze(source);
  }
}
