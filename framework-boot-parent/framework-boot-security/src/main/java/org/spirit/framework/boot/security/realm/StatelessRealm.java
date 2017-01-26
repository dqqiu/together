package org.spirit.framework.boot.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.spirit.framework.boot.security.stateless.StatelessToken;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.realm.StatelessRealm.java
 * @Description   : qiudequan 无会话状态Realm
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午9:42:58 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class StatelessRealm extends AuthorizingRealm {
  
  @Override
  public boolean supports(AuthenticationToken token) {
    // 限制只支持StatelessToken类型
    return token instanceof StatelessToken;
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // 为用户设置角色、权限等信息
    SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
//    // 设置角色信息
//    authorizationInfo.setRoles(roles);
//    // 设置权限信息
//    authorizationInfo.setStringPermissions(stringPermissions);
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    StatelessToken statelessToken = (StatelessToken) token;
    // 根据token获取用户名
    String username = statelessToken.getUsername();
    // 根据token获取凭证(消息摘要)
    String credentials = (String) statelessToken.getCredentials();
    // 进行客户端消息摘要和服务器端消息摘要的匹配
    return new SimpleAuthenticationInfo(username, credentials, getName());
  }

}
