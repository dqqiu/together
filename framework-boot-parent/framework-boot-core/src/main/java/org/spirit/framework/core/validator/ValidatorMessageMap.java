package org.spirit.framework.core.validator;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidateMessageMap.java
 * @Description   : qiudequan 校验器错误信息Map
 * @Author        : qiudequan
 * @Creation Date : 2016年11月29日 下午12:24:08 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月29日        create
 */
public class ValidatorMessageMap<K, V> extends LinkedHashMap<K, V> {

  private static final long serialVersionUID = -7074249302511536234L;

  /**
   * 重写toString()方法,手动转换为json
   */
  @Override
  public String toString() {
    Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
    if(!iterator.hasNext()){
      return "[]";
    }
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("[");
    
    while(iterator.hasNext()) {
      Map.Entry<K, V> next = iterator.next();
      K key = next.getKey();
      V value = next.getValue();
      sBuilder.append("{");
      sBuilder.append("\"").append(key).append("\" : ");
      sBuilder.append("\"").append(value).append("\"");
      sBuilder.append("}");
      if(iterator.hasNext()){
        sBuilder.append(", ");
      }
    }
    sBuilder.append("]");
    return sBuilder.toString();
  }
  
}