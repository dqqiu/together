package org.spirit.together.dictionary.translate;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.ResolverSourceProperties.java
 * @Description   : qiudequan 字典翻译请求来源解析类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午10:56:23 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public class AnalyzeSourceProperties {
  
  private static final Logger logger = LoggerFactory.getLogger(AnalyzeSourceProperties.class);
  public void analyze(Object source) {
    if(source == null) {
      return;
    }

    // 处理复杂类型
    handlerComplexType(source);
  }

  /**
   *  @Description	: qiudequan 处理复杂类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:17:51 
   *  @Author         : qiudequan
   */
  private void handlerComplexType(Object source) {
    if(source == null) {
      return;
    }
    
    if(isTogetherType(source.getClass())) {
      analyzeTogetherType(source);
    }
    
    if(source.getClass().isArray()) {
      
    }
    
    if(source instanceof Collection<?>) {
      analyzeComplexTypeForCollection((Collection<?>)source);
    }
    
    if(source instanceof Map<?, ?>) {
      analyzeComplexTypeForMap((Map<?, ?>) source);
    }
  }

  /**
   *  @Description	: qiudequan 解析本项目中的自定义类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:01 
   *  @Author         : qiudequan
   */
  private void analyzeTogetherType(Object source) {

  }
  
  /**
   *  @Description	: qiudequan 解析集合类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:14 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForCollection(Collection<?> source) {

  }
  
  /**
   *  @Description	: qiudequan 解析Map类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:32 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForMap(Map<?, ?> source) {

  }
  
  /**
   *  @Description	: qiudequan 解析数组类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:42 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForArray(Object[] source) {

  }

  /**
   *  @Description	: qiudequan 判断是否为本项目自定义的类型
   *  @param          : @param type
   *  @param          : @return
   *  @return 		: boolean
   *  @Creation Date  : 2016年11月10日 下午5:19:01 
   *  @Author         : qiudequan
   */
  private boolean isTogetherType(Class<?> type){
    String typeName = type.getName();
    return "org.spirit".equals(typeName);
  }

  /**
   *  @Description	: qiudequan 判断是否为需要翻译的字段，规则自行定义
   *  @param          : @param propertyDescriptor
   *  @param          : @return
   *  @return 		: boolean
   *  @Creation Date  : 2016年11月10日 下午5:19:18 
   *  @Author         : qiudequan
   */
  private boolean isDictionaryProperty(PropertyDescriptor propertyDescriptor) {
    return (propertyDescriptor.getPropertyType().equals(String.class))
        && (propertyDescriptor.getName().startsWith("dict") || propertyDescriptor.getName().endsWith("Cd"));
  }

}
