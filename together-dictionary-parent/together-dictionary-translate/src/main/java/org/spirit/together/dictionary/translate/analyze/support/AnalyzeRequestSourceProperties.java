package org.spirit.together.dictionary.translate.analyze.support;

import java.util.HashMap;
import java.util.Map;

import org.spirit.together.dictionary.translate.analyze.AnalyzeSourceProperties;
import org.spirit.together.dictionary.translate.meta.DictionaryTranslateRequestMeta;
import org.spirit.together.dictionary.translate.registry.DictionaryCategory;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourceMapping;
import org.spirit.together.dictionary.translate.registry.support.DictionaryResourcesRegistry;
import org.spirit.together.dictionary.translate.registry.support.PublicRemotingRegistry;
import org.springframework.beans.BeanWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.analyze.support.AnalyzeRequestSourceProperties.java
 * @Description   : qiudequan 来源请求分析类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午7:06:31 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class AnalyzeRequestSourceProperties extends AnalyzeSourceProperties {

  @Override
  public void handlerAnalyze(BeanWrapper source, String propertyName, Map<String, Map<String, DictionaryCategory>> categoryMap) {
    Object propertyValue = source.getPropertyValue(propertyName);
    if(propertyValue == null || !StringUtils.hasText((CharSequence) propertyName)) {
      return;
    }

    // 判断是否为具有明确释义的数据字典
    if(isExplicit(propertyName)) {
      beforeRequest(propertyName, propertyValue, DictionaryResourcesRegistry.EXPLICIT, categoryMap);
    } else {                            // 通用数据字典
      generateCategory(DictionaryResourcesRegistry.PUBLIC, categoryMap);
      
      DictionaryRemotingResourceMapping resourceMapping = DictionaryResourcesRegistry.PUBLIC.mappings.get(PublicRemotingRegistry.MT_DATA.getCode());
      
      registerCategories(propertyName, propertyValue, resourceMapping, DictionaryResourcesRegistry.PUBLIC, categoryMap);
    }
  }

  /**
   *  @Description	: qiudequan 请求前处理，生成并注册字典分类
   *  @param          : @param propertyName
   *  @param          : @param propertyValue
   *  @param          : @param resourceRegistry
   *  @param          : @param categoryMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午9:39:46 
   *  @Author         : qiudequan
   */
  private void beforeRequest(String propertyName, Object propertyValue,
      DictionaryResourcesRegistry resourceRegistry,
      Map<String, Map<String, DictionaryCategory>> categoryMap) {
    generateCategory(resourceRegistry, categoryMap);
    
    DictionaryRemotingResourceMapping resourceMapping = resourceRegistry.mappings.get(propertyName);
    
    registerCategories(propertyName, propertyValue, resourceMapping, resourceRegistry, categoryMap);
  }

  /**
   *  @Description	: qiudequan 注册字典分类
   *  @param          : @param propertyName
   *  @param          : @param propertyValue
   *  @param          : @param resourceMapping
   *  @param          : @param resourcesRegistry
   *  @param          : @param categoryMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午7:44:57 
   *  @Author         : qiudequan
   */
  private void registerCategories(String propertyName, Object propertyValue,
      DictionaryRemotingResourceMapping resourceMapping, DictionaryResourcesRegistry resourcesRegistry,
      Map<String, Map<String, DictionaryCategory>> categoryMap) {
    // 检查当前字典对应的资源分类是否已存在
    String code = resourceMapping.getRegistry().getCode();
    
    DictionaryCategory dictionaryCategory = categoryMap.get(resourcesRegistry.code).get(code);
    if(dictionaryCategory == null) {
      // 没有创建则先创建
      dictionaryCategory = new DictionaryCategory(resourceMapping.getRemotingAccessor());
      // 加入分类注册器
      categoryMap.get(resourcesRegistry.code).put(code, dictionaryCategory);
    }
    
    // 将当前的字典分类加入对应的字典分类中
    categoryMap.get(resourcesRegistry.code).get(code).add(new DictionaryTranslateRequestMeta());
  }

  /**
   *  @Description	: qiudequan 建立字典分类Map
   *  @param          : @param dictionaryResourcesRegistry
   *  @param          : @param propetyMap
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午7:26:11 
   *  @Author         : qiudequan
   */
  private void generateCategory(DictionaryResourcesRegistry dictionaryResourcesRegistry,
      Map<String, Map<String, DictionaryCategory>> propetyMap) {
    if (CollectionUtils.isEmpty(propetyMap.get(dictionaryResourcesRegistry.code))) {
      propetyMap.put(dictionaryResourcesRegistry.code, new HashMap<String, DictionaryCategory>());
    }
  }

}
