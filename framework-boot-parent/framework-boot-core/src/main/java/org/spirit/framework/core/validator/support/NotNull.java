package org.spirit.framework.core.validator.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.support.NotNull.java
 * @Description   : qiudequan 非空校验注解
 * @Author        : qiudequan
 * @Creation Date : 2016年11月28日 下午4:55:46 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月28日        create
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
  /**
   *  @Description	: qiudequan 分组
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午12:10:54 
   *  @Author         : qiudequan
   */
  String[] groups() default { };
  
  /**
   *  @Description	: qiudequan 错误信息
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午12:11:01 
   *  @Author         : qiudequan
   */
  String errMsg() default "{org.spirit.framework.core.validator.support.NotNull.errMsg}";
}
