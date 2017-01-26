package org.spirit.framework.boot.security.stateless;

import java.util.Map;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.StatelessToken.java
 * @Description   : qiudequan 无会话状态Token
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午9:28:02 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class StatelessToken implements AuthenticationToken {

  private static final long serialVersionUID = 8049143423570403089L;
  /** 客户端传入的用户名(用户身份) */
  private String username;
  /** 客户端传入的参数 */
  private Map<String, ?> params;
  /** 客户端传入的消息摘要(凭证) */
  private String clientDigest;

  /**
   * 获取凭证
   */
  public Object getCredentials() {
    return clientDigest;
  }

  /**
   * 获取用户身份
   */
  public Object getPrincipal() {
    return username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Map<String, ?> getParams() {
    return params;
  }

  public void setParams(Map<String, ?> params) {
    this.params = params;
  }

  public String getClientDigest() {
    return clientDigest;
  }

  public void setClientDigest(String clientDigest) {
    this.clientDigest = clientDigest;
  }
  
}
