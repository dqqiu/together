package org.spirit.framework.core.validator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidateMessageGroup.java
 * @Description   : qiudequan 校验错误信息组
 * @Author        : qiudequan
 * @Creation Date : 2016年11月30日 上午9:49:08 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月30日        create
 */
public class ValidateMessageGroup<K, V> extends HashMap<K, V> {

  
  private static final long serialVersionUID = -2133354586089827980L;

  @Override
  public String toString() {
    Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
    if(!iterator.hasNext()){
      return "{\"validateMessageGroup\" : [ ]}";
    }
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{\"validateMessageGroup\" : [");
    
    while(iterator.hasNext()) {
      Map.Entry<K, V> next = iterator.next();
      K key = next.getKey();
      V value = next.getValue();
      sBuilder.append("{");
      sBuilder.append("\"").append(key).append("\" : ");
      sBuilder.append(value.toString());
      sBuilder.append("}");
      if(iterator.hasNext()){
        sBuilder.append(",");
      }
    }
    sBuilder.append("]}");
    return sBuilder.toString();
  }
  
}
