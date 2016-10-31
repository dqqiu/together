package org.spirit.framework.boot.web.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.configuration.DruidConfiguration.java
 * @Description   : qiudequan druid配置
 * @Author        : qiudequan
 * @Creation Date : 2016年10月14日 下午10:21:32 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月14日        create
 */
@Configuration
public class DruidConfiguration {
    /**
     * SpringBoot中使用ServletRegistrationBean注册一个Servlet
     *  @Description	: qiudequan 注册StatViewServlet
     *  @return         : ServletRegistrationBean
     *  @Creation Date  : 2016年10月14日 下午11:01:25 
     *  @Author         : qiudequan
     */
    @Bean
    public ServletRegistrationBean DruidStateViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        
        // 设置访问白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 设置访问黑名单，与白名单有重复时，黑名单生效，黑名单优先级高于白名单
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        // 设置访问用户名和密码
        servletRegistrationBean.addInitParameter("loginUsername", "dqqiu");
        servletRegistrationBean.addInitParameter("loginPassword", "qiu842276463");
        // 设置是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        
        return servletRegistrationBean;
    }
    
    /**
     * SpringBoot中使用FilterRegistrationBean注册一个Filter
     *  @Description	: qiudequan 注册StatFilter
     *  @return         : FilterRegistrationBean
     *  @Creation Date  : 2016年10月14日 下午11:02:16 
     *  @Author         : qiudequan
     */
    @Bean
    public FilterRegistrationBean DruidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        
        // 添加忽略的格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        
        return filterRegistrationBean;
    }
}
