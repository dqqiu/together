package org.spirit.framework.core.utils;

import java.util.UUID;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.IDGenerator.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月2日 下午4:24:30 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月2日        create
 */
public class IDGenerator {
  public static String generate(){
    String str = UUID.randomUUID().toString();
    return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18)
        + str.substring(19, 23) + str.substring(24);
  }
}
