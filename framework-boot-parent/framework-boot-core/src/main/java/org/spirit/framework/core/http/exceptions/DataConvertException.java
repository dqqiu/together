package org.spirit.framework.core.http.exceptions;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.http.exceptions.DataConvertException.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月15日 下午4:20:13 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月15日        create
 */
public class DataConvertException extends RuntimeException {

  private static final long serialVersionUID = -6343680758690556654L;

  private static final String ERROR_MSG = "类型转换异常";
  public DataConvertException() {
    super(ERROR_MSG);
  }

  public DataConvertException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataConvertException(String message) {
    super(message);
  }

  public DataConvertException(Throwable cause) {
    super(cause);
  }

  
  
}
