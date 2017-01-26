package org.spirit.framework.boot.security.stateless;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.stateless.StatelessHttpMethodPermissionFilter.java
 * @Description   : qiudequan HttpMethod权限过滤器，可用于restful风格url请求方法过滤
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午10:15:59 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class StatelessHttpMethodPermissionFilter extends HttpMethodPermissionFilter {
  // 未通过权限认证返回的信息
  private static final String NO_PERMISSION_MSG = "未通过权限认证";
  
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws IOException {
    Subject subject = getSubject(request, response);
    // 若无用户身份信息跳转至登录页面,否则返回HTTP状态401
    if(subject.getPrincipal() == null) {
      saveRequestAndRedirectToLogin(request, response);
    } else {
      HttpServletResponse resp = (HttpServletResponse) response;
      resp.sendError(HttpServletResponse.SC_FORBIDDEN, NO_PERMISSION_MSG);
    }
    return false;
  }

  
}
