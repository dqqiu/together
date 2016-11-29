package org.spirit.framework.core.validator.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.support.Pattern.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月28日 下午5:01:24 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月28日        create
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Pattern {
  /**
   *  @Description	: qiudequan 正则表达式
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午12:11:26 
   *  @Author         : qiudequan
   */
  String regex();
  
  /**
   *  @Description	: qiudequan 错误信息
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午12:11:35 
   *  @Author         : qiudequan
   */
  String errMsg() default "{org.spirit.framework.core.validator.support.Pattern.errMsg}";
  
  public static enum Regex {
    EMAIL("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"),               // 邮箱
    IP("(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)"),                            // IP
    PHONE("^((\\(\\d{2,3}\\))|(\\d{3}\\-))?13\\d{9}$"),                 // 手机号
    MOBILE("^((\\(\\d{2,3}\\))|(\\d{3}\\-))?(\\(0\\d{2,3}\\)|0\\d{2,3}-)?[1-9]\\d{6,7}(\\-\\d{1,4})?$"),        // 电话号码
    URL("http://(/[\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?"),              // URL
    POSTCODE("^[1-9]\\d{5}$");                                          // 邮编
    
    
    private String value;
    
    private Regex(String value){
      this.value = value;
    }
  }
}
