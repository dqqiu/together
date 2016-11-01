package org.spirit.together.security.rest.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Project       : together-security-rest
 * @Program Name  : org.spirit.together.security.rest.realm.TogetherRealm.java
 * @Description   : qiudequan 身份验证
 * @Author        : qiudequan
 * @Creation Date : 2016年10月31日 下午2:08:25 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月31日        create
 */
public class TogetherRealm extends AuthorizingRealm {

  /**
   * 授权
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // 授权
    return null;
  }

  /**
   * 认证信息
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    // 进行身份验证
    
    
    return null;
  }

}
