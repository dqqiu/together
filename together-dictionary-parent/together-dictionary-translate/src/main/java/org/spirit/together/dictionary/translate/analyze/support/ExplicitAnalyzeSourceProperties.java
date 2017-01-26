package org.spirit.together.dictionary.translate.analyze.support;

import java.util.Map;

import org.spirit.together.dictionary.translate.analyze.AnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.registry.DictionaryCategory;
import org.springframework.beans.BeanWrapper;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.analyze.support.ExplicitAnalyzeSourceProperties.java
 * @Description   : qiudequan 具有明确释义的字典数据解析类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月11日 上午10:22:38 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月11日        create
 */
public class ExplicitAnalyzeSourceProperties extends AnalyzeSourceProperties {

  @Override
  public void handlerAnalyze(BeanWrapper source, String propertyName,
      Map<String, Map<String, DictionaryCategory>> categoryMap) {
    
  }

}
