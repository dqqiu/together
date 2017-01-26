package org.spirit.framework.core.exceptions;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.exceptions.InternalServerException.java
 * @Description   : qiudequan 内部服务异常类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午1:34:53 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class InternalServerException extends RuntimeException {

  private static final long serialVersionUID = 8491740971482723898L;

  public InternalServerException() {
    super();
  }

  public InternalServerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }

  public InternalServerException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public InternalServerException(String arg0) {
    super(arg0);
  }

  public InternalServerException(Throwable arg0) {
    super(arg0);
  }

  
}
