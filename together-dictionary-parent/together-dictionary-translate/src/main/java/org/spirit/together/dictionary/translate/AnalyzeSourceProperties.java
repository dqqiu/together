package org.spirit.together.dictionary.translate;

import java.beans.PropertyDescriptor;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.ResolverSourceProperties.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月10日 上午10:56:23 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月10日        create
 */
public class AnalyzeSourceProperties {
  public void analyze(Object source) {
    
  }
  
  private void analyzeComplexType(Object source) {
    
  }
  
  private boolean isTogetherType(Class<?> type){
    String typeName = type.getName();
    return "org.spirit".equals(typeName);
  }
  
  private boolean isDictionaryProperty(PropertyDescriptor propertyDescriptor) {
    return (propertyDescriptor.getPropertyType().equals(String.class))
        && (propertyDescriptor.getName().startsWith("dict") || propertyDescriptor.getName().endsWith("Cd"));
  }
  
}
