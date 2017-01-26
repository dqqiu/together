package org.spirit.framework.boot.security.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.spirit.framework.boot.security.realm.RealmEnum;
import org.spirit.framework.boot.security.realm.StatelessRealm;
import org.spirit.framework.boot.security.stateless.StatelessAuthcFilter;
import org.spirit.framework.boot.security.stateless.StatelessHttpMethodPermissionFilter;
import org.spirit.framework.boot.security.stateless.StatelessSubjectFactory;
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

  @Bean("statelessRealm")
  public StatelessRealm getStatelessRealm(){
    StatelessRealm statelessRealm = new StatelessRealm();
    statelessRealm.setCachingEnabled(false);
    return statelessRealm;
  }

  @Bean("statelessAuthcFilter")
  public StatelessAuthcFilter getStatelessAuthcFilter() {
    return new StatelessAuthcFilter();
  }

  @Bean("statelessHttpMethodPermissionFilter")
  public StatelessHttpMethodPermissionFilter getStatelessHttpMethodPermissionFilter() {
    return new StatelessHttpMethodPermissionFilter();
  }

  @Bean("statelessSubjectFactory")
  public StatelessSubjectFactory getStatelessSubjectFactory() {
    return new StatelessSubjectFactory();
  }

  /**
   *  @Description	: qiudequan 安全管理器
   *  @param          : @param statelessRealm 无状态回话realm
   *  @param          : @param subjectFactory Subject工厂
   *  @param          : @param sessionManager 会话管理器
   *  @param          : @return
   *  @return         : DefaultWebSecurityManager
   *  @Creation Date  : 2016年12月3日 下午9:04:19 
   *  @Author         : qiudequan
   */
  @Bean(name = "securityManager")
  public DefaultWebSecurityManager getDefaultWebSecurityManager(AuthorizingRealm statelessRealm,
      DefaultWebSubjectFactory subjectFactory, DefaultSessionManager sessionManager) {
    DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();

    // 注册Realm
    List<Realm> realms = RealmEnum.getRealms();
    if(CollectionUtils.isNotEmpty(realms)){
      realms.add(statelessRealm);
      webSecurityManager.setRealms(realms);
    } else {
      webSecurityManager.setRealm(statelessRealm);
    }

    // 设置不启用session存储
    DefaultSubjectDAO subjectDAO = (DefaultSubjectDAO) webSecurityManager.getSubjectDAO();
    DefaultSessionStorageEvaluator sessionStorageEvaluator = (DefaultSessionStorageEvaluator) subjectDAO.getSessionStorageEvaluator();
    sessionStorageEvaluator.setSessionStorageEnabled(false);

    // 用户授权/认证信息Cache, 采用EhCache 缓存
    webSecurityManager.setCacheManager(getEhCacheManager());
    webSecurityManager.setSubjectFactory(subjectFactory);
    return webSecurityManager;
  }

  /**
   *  @Description	: qiudequan shiro过滤器
   *  @param          : @param securityManager
   *  @param          : @param statelessAuthcFilter
   *  @param          : @return
   *  @return         : ShiroFilterFactoryBean
   *  @Creation Date  : 2016年12月3日 下午11:29:25 
   *  @Author         : qiudequan
   */
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager,
      StatelessAuthcFilter statelessAuthcFilter) {
    ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
    filterFactoryBean.setSecurityManager(securityManager);
    
    // 注册过滤器
    Map<String, Filter> filters = new HashMap<>();
    filters.put("statelessAuthc", statelessAuthcFilter);
    
    filterFactoryBean.setFilters(filters);
    filterFactoryBean.setFilterChainDefinitions("/**=statelessAuthc");
    return filterFactoryBean;
  }

}
