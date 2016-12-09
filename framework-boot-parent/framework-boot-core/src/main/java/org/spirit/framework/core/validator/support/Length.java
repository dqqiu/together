package org.spirit.framework.core.validator.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.support.Length.java
 * @Description   : qiudequan 长度校验注解
 * @Author        : qiudequan
 * @Creation Date : 2016年11月28日 下午4:58:51 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月28日        create
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Length {
  /**
   *  @Description	: qiudequan 最小长度
   *  @param          : @return
   *  @return 		: int
   *  @Creation Date  : 2016年11月29日 下午12:09:49 
   *  @Author         : qiudequan
   */
  int min() default 0;
  
  /**
   *  @Description	: qiudequan 最大长度
   *  @param          : @return
   *  @return 		: int
   *  @Creation Date  : 2016年11月29日 下午12:10:00 
   *  @Author         : qiudequan
   */
  int max() default Integer.MAX_VALUE;
  
  /**
   *  @Description	: qiudequan 分组
   *  @param          : @return
   *  @return 		: String[]
   *  @Creation Date  : 2016年11月29日 下午12:10:26 
   *  @Author         : qiudequan
   */
  String[] groups() default { };

  /**
   *  @Description	: qiudequan 错误信息
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午12:10:34 
   *  @Author         : qiudequan
   */
  String errMsg() default "{org.spirit.framework.core.validator.support.Length.errMsg}";
  
}
