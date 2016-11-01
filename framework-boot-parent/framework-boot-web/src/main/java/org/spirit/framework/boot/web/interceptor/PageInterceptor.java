package org.spirit.framework.boot.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.boot.web.properties.PageProperties;
import org.spirit.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.interceptor.PageInterceptor.java
 * @Description   : qiudequan 分页拦截
 * @Author        : qiudequan
 * @Creation Date : 2016年10月14日 下午4:15:47 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月14日        create
 */
public class PageInterceptor implements HandlerInterceptor {

  @Autowired
  private PageProperties pageProperties;
  
  private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
  
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg,
      Exception arg3) throws Exception {
    
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg,
      ModelAndView arg3) throws Exception {
    
  }

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg)
      throws Exception {
    // 存在分页参数[当前页]选项，则进行分页
    Integer pageNo = StringUtils.integerOf(request.getParameter(pageProperties.getPageNoName()));
    try {
      if(pageNo != null){
        Integer pageSize = StringUtils.integerOf(request.getParameter(pageProperties.getPageSizeName()));
        PageHelper.startPage(pageNo, pageProperties.getPageSize() == null ? pageProperties.getPageSize() : pageSize);
      }
    } catch (Exception e) {
      logger.warn("preHandler exception.[PageInterceptor]", e);
    }
    return true;
  }

}
