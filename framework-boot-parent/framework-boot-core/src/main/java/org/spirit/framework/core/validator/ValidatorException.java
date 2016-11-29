package org.spirit.framework.core.validator;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidatorException.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月29日 下午12:49:24 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月29日        create
 */
public class ValidatorException extends RuntimeException {

  private static final long serialVersionUID = -3148389080808265886L;

  public ValidatorException() {
    super();
  }

  public ValidatorException(String message, Throwable cause) {
    super(message, cause);
  }

  public ValidatorException(String message) {
    super(message);
  }

  public ValidatorException(Throwable cause) {
    super(cause);
  }
  
}
