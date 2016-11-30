package org.spirit.framework.core.validator;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidatorTest.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月29日 下午1:28:19 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月29日        create
 */
public class ValidatorTest {
  public static void main(String[] args) {
    User user = new User();
    user.setUserName("Mike");
    ValidatorUtils.validate(user, "用户Mike");
  }
}
