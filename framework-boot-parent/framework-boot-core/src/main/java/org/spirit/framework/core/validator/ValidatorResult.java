package org.spirit.framework.core.validator;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidatorResult.java
 * @Description   : qiudequan 校验器结果
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午4:15:38 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class ValidatorResult<K, V> extends LinkedHashMap<K, V> {
  
  private static final long serialVersionUID = 9129573250447561337L;
  
  /** 备注 */
  private String remark;

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  /**
   * 重写toString()方法，手动转换为指定json格式
   */
  @Override
  public String toString() {
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append("{\"remark\" : \"").append(getRemark()).append("\", ");
    Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
    if(!iterator.hasNext()){
      return sBuilder.append("\"errors\" : []}").toString();
    }
    sBuilder.append("\"errors\" : [");
    
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
