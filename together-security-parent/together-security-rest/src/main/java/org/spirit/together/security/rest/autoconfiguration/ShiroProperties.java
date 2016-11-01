package org.spirit.together.security.rest.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Project       : together-security-rest
 * @Program Name  : org.spirit.together.security.rest.autoconfiguration.ShiroProperties.java
 * @Description   : qiudequan Shiro属性类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月31日 下午1:55:17 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月31日        create
 */

@ConfigurationProperties(prefix = "together.shiro")
public class ShiroProperties {
  /** 登录url */
  private String loginUrl;
  /** 登录成功后跳转的url */
  private String successUrl;
  /** 未通过权限认证跳转的url */
  private String unauthorizedUrl;
  public String getLoginUrl() {
    return loginUrl;
  }
  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }
  public String getSuccessUrl() {
    return successUrl;
  }
  public void setSuccessUrl(String successUrl) {
    this.successUrl = successUrl;
  }
  public String getUnauthorizedUrl() {
    return unauthorizedUrl;
  }
  public void setUnauthorizedUrl(String unauthorizedUrl) {
    this.unauthorizedUrl = unauthorizedUrl;
  }

}
