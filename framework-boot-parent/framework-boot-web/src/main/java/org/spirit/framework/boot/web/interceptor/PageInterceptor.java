package org.spirit.framework.boot.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.interceptor.PageInterceptor.java
 * @Description   : TODO qiudequan 分页拦截
 * @Author        : qiudequan
 * @Creation Date : 2016年10月14日 下午4:15:47 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月14日        create
 */
public class PageInterceptor implements HandlerInterceptor {

  @SuppressWarnings("unused")
  private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
  
  public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
      Exception arg3) throws Exception {
    
  }

  public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
      ModelAndView arg3) throws Exception {
    
  }

  public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)
      throws Exception {
    return false;
  }

}
