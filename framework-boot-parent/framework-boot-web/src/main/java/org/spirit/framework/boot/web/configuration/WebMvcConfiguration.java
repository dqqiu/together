package org.spirit.framework.boot.web.configuration;

import org.spirit.framework.boot.web.interceptor.PageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.configuration.WebMvcConfiguration.java
 * @Description   : TODO qiudequan SpringMvc相关配置
 * @Author        : qiudequan
 * @Creation Date : 2016年10月15日 下午4:15:25 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月15日        create
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
  
  /**
   * 配置拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册分页拦截器,并配置拦截路径
    registry.addInterceptor(new PageInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
  
  /**
   * 静态资源文件配置,此处暂不配置
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    super.addResourceHandlers(registry);
  }
  
}
