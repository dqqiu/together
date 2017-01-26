package org.spirit.framework.boot.security.stateless;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.stateless.StatelessAuthcFilter.java
 * @Description   : qiudequan 无会话状态权限过滤器，根据当前请求上下文信息每次请求时都要登录的认证过滤器
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午9:48:18 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class StatelessAuthcFilter extends AccessControlFilter {

  protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
  
  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
      throws Exception {
    // 在此处实现通过权限认证的请求
    String[] permissions = (String[]) mappedValue;
    if(ArrayUtils.isEmpty(permissions)) {
      return true;
    }
    return getSubject(request, response).isPermitted(permissions[0]);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    // 在此处实现未通过权限认证的请求
    return false;
  }

  
}
