package org.spirit.together.dictionary.translate.analyze;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.utils.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.ResolverSourceProperties.java
 * @Description   : qiudequan 字典翻译请求来源解析类，根据字典类型下发至指定之类进行处理
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午10:56:23 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public abstract class AnalyzeSourceProperties {
  
  private static final Logger logger = LoggerFactory.getLogger(AnalyzeSourceProperties.class);
  
  /**
   *  @Description	: qiudequan 执行解析，强制子类实现，方便对不同类型的数据字典进行解析
   *  @param          : @param source
   *  @param          : @param propertyName
   *  @return 		: void
   *  @Creation Date  : 2016年11月11日 上午10:24:47 
   *  @Author         : qiudequan
   */
  public abstract void handlerAnalyze(BeanWrapper source, String propertyName);
  
  public void analyze(Object source) {
    if(source == null) {
      return;
    }

    // 处理复杂类型
    handlerComplexType(source);
  }

  /**
   *  @Description	: qiudequan 处理复杂类型,包含自定义类，数组，Collection集合，Map集合
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:17:51 
   *  @Author         : qiudequan
   */
  private void handlerComplexType(Object source) {
    if(source == null) {
      return;
    }
    
    // 自定义类型：Together中的类
    if(isTogetherType(source.getClass())) {
      analyzeTogetherType(source);
    }
    
    // 数组类型
    if(source.getClass().isArray()) {
      analyzeComplexTypeForArray((Object[]) source);
    }
    
    // 集合类型
    if(source instanceof Collection<?>) {
      analyzeComplexTypeForCollection((Collection<?>)source);
    }
    
    // Map集合类型
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
    BeanWrapper beanWrapper = new BeanWrapperImpl();
    // 获取类中属性描述器，其中包含属性名，属性值等信息
    PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
    for (int i = 0; i < propertyDescriptors.length; i++) {
      PropertyDescriptor property = propertyDescriptors[i];
      String propertyName = property.getName();
      Object value = beanWrapper.getPropertyValue(propertyName);
      // 忽略空值
      if(value == null) {
        continue;
      }
      
      // 忽略空字符串
      if((value instanceof String) && StringUtils.hasText((CharSequence) value)) {
        continue;
      }
      
      // 由于属性可能为任意类型，所以需要再次判断其类型--->递归handlerComplexType
      handlerComplexType(value);
      
      // 直接忽略无用字段(即无需翻译的字段). 注：此处Dscp结尾的字段是承载相应翻译结果的字段，所以需要忽略
      if(!isDictionaryProperty(property) || propertyName.endsWith("Dscp")) {
        continue;
      }
      
      // 解析字段
      handlerAnalyze(beanWrapper, propertyName);
    }
  }
  
  /**
   *  @Description	: qiudequan 解析集合类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:14 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForCollection(Collection<?> source) {
    if(logger.isDebugEnabled()) {
      logger.debug("The field that needs to be translated is an collection type");
    }
    
    for (Object value : source) {
      handlerComplexType(value);
    }
  }
  
  /**
   *  @Description	: qiudequan 解析Map类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:32 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForMap(Map<?, ?> source) {
    if(logger.isDebugEnabled()) {
      logger.debug("The field that needs to be translated is an map type");
    }
    
    for(Object value : source.values()) {
      handlerComplexType(value);
    }
  }
  
  /**
   *  @Description	: qiudequan 解析数组类型
   *  @param          : @param source
   *  @return 		: void
   *  @Creation Date  : 2016年11月10日 下午5:18:42 
   *  @Author         : qiudequan
   */
  private void analyzeComplexTypeForArray(Object[] source) {
    if(logger.isDebugEnabled()) {
      logger.debug("The field that needs to be translated is an array type");
    }
    
    for (Object value : source) {
      handlerComplexType(value);
    }
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
    if(logger.isDebugEnabled()) {
      logger.debug("The field that needs to be translated is an customer type of together");
    }
    String typeName = type.getName();
    return "org.spirit".equals(typeName);
  }

  /**
   *  @Description	: qiudequan 判断是否为需要翻译的字段，规则自行定义，一般定义为以"XXXX"开头或结尾
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
