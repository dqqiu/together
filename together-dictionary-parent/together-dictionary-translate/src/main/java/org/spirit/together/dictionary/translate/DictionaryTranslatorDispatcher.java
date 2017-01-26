package org.spirit.together.dictionary.translate;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.together.dictionary.translate.analyze.support.AnalyzeRequestSourceProperties;
import org.spirit.together.dictionary.translate.analyze.support.AnalyzeResultBeanProperties;
import org.spirit.together.dictionary.translate.analyze.support.ExplicitAnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.analyze.support.PublicAnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.registry.DictionaryCategory;

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
  
  final Logger logger = LoggerFactory.getLogger(getClass());
  
  /**
   *  @Description	: qiudequan 对请求进行分析
   *  @param          : @param source
   *  @param          : @param categoryMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午10:09:20 
   *  @Author         : qiudequan
   */
  public void analyzeRequest(Object source, Map<String, Map<String, DictionaryCategory>> categoryMap) {
    new AnalyzeRequestSourceProperties().analyze(source, categoryMap);
  }
  
  /**
   *  @Description	: qiudequan 对请求结果进行分析，主要为设置翻译后的值
   *  @param          : @param source
   *  @param          : @param categoryMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午10:09:31 
   *  @Author         : qiudequan
   */
  public void analyzeResult(Object source, Map<String, Map<String, DictionaryCategory>> categoryMap) {
    new AnalyzeResultBeanProperties().analyze(source, categoryMap);
  }
  
  /**
   *  @Description	: qiudequan 执行远程请求
   *  @param          : @param categoryMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午8:01:27 
   *  @Author         : qiudequan
   */
  public void executeRemotingRequest(Map<String, Map<String, DictionaryCategory>> categoryMap) {
    DictionaryCategory dictionaryCategory = null;
    for (Map.Entry<String, Map<String, DictionaryCategory>> entry : categoryMap.entrySet()) {
      for (Map.Entry<String, DictionaryCategory> categories : entry.getValue().entrySet()) {
        dictionaryCategory = categories.getValue();
        if(dictionaryCategory.getAccessor() != null) {
          // 执行远程请求
          dictionaryCategory.getAccessor().remotingRequest(dictionaryCategory.getCategories());
        }
      }
    }
  }
}
