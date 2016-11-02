package org.spirit.framework.boot.security.configuration;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.boot.security.realm.TogetherRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project       : together-security-rest
 * @Program Name  : org.spirit.together.security.rest.autoconfiguration.ShiroConfiguraion.java
 * @Description   : qiudequan Shiro配置类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月31日 上午10:00:24 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月31日        create
 */

@Configuration
public class ShiroConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);
  
  @Bean
  public EhCacheManager getEhCacheManager() {
    EhCacheManager cacheManager = new EhCacheManager();
    cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
    return cacheManager;
  }
  
  @Bean(name = "lifecycleBeanPostProcessor")
  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
      return new LifecycleBeanPostProcessor();
  }

  @Bean
  public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
      DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
      daap.setProxyTargetClass(true);
      return daap;
  }
  
  public TogetherRealm getTogetherRealm(){
    TogetherRealm togetherRealm = new TogetherRealm();
    return togetherRealm;
  }
  
  @Bean(name = "securityManager")
  public DefaultWebSecurityManager getDefaultWebSecurityManager() {
      DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
//      together.setRealm(myShiroRealm);
      //    <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 --> 
      webSecurityManager.setCacheManager(getEhCacheManager());
      return webSecurityManager;
  }

  
}
