package org.spirit.together.dictionary.translate.analyze.support;

import java.util.Map;

import org.spirit.framework.core.utils.StringUtils;
import org.spirit.together.dictionary.translate.analyze.AnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.meta.DictionaryMeta;
import org.spirit.together.dictionary.translate.meta.DictionaryTranslateRequestMeta;
import org.spirit.together.dictionary.translate.registry.DictionaryCategory;
import org.spirit.together.dictionary.translate.registry.support.DictionaryResourcesRegistry;
import org.spirit.together.dictionary.translate.registry.support.PublicRemotingRegistry;
import org.springframework.beans.BeanWrapper;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.analyze.support.AnalyzeResultBeanProperties.java
 * @Description   : qiudequan 请求结果分析类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午9:47:44 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class AnalyzeResultBeanProperties extends AnalyzeSourceProperties {

  @Override
  public void handlerAnalyze(BeanWrapper source, String propertyName,
      Map<String, Map<String, DictionaryCategory>> categoryMap) {
    // 分析是否为具有明确释义的字典类别
    if(isExplicit(propertyName)) {
      // 获取字典分类，并设置翻译后的值
      Map<String, DictionaryCategory> categories = categoryMap.get(DictionaryResourcesRegistry.EXPLICIT.code);
      DictionaryCategory dictionaryCategory = categories.get(propertyName);
      setProperty(source, dictionaryCategory, propertyName);
    } else {
      Map<String, DictionaryCategory> categories = categoryMap.get(DictionaryResourcesRegistry.PUBLIC.code);
      DictionaryCategory dictionaryCategory = categories.get(PublicRemotingRegistry.MT_DATA.getCode());
      setProperty(source, dictionaryCategory, propertyName);
    }
  }
  
  /**
   *  @Description	: qiudequan 设置翻译后的值
   *  @param          : @param source
   *  @param          : @param dictionaryCategory
   *  @param          : @param propertyName
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午10:03:52 
   *  @Author         : qiudequan
   */
  private void setProperty(BeanWrapper source, DictionaryCategory dictionaryCategory, String propertyName) {
    DictionaryMeta dictionaryMeta = dictionaryCategory.getCategories().get(propertyName + "_" + source.getPropertyValue(propertyName));
    DictionaryTranslateRequestMeta translateRequestMeta = (DictionaryTranslateRequestMeta) dictionaryMeta;
    if(translateRequestMeta.getDscp() == null || !StringUtils.hasText((CharSequence) translateRequestMeta.getDscp())) {
      return;
    }
    source.setPropertyValue(translateRequestMeta.getCdDscpName(), translateRequestMeta.getDscp());
  }

}
