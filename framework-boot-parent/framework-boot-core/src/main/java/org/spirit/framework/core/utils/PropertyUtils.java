package org.spirit.framework.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Project : framework-core
 * @Program Name : com.ljt.framework.core.utils.PropertyUtils.java
 * @Description : 系统属性工具类
 * @Author : wangchao
 * @Creation Date : 2016年3月18日 上午10:33:13
 * @ModificationHistory Who When What ---------- ------------- -----------------------------------
 *                      wangchao 2016年3月18日 create
 */
@Component
public class PropertyUtils implements EnvironmentAware, BeanDefinitionRegistryPostProcessor {

  private static Environment env;

  public void setEnvironment(Environment environment) {
    env = environment;
  }

  public static String getProperty(String key) {
    return env.getProperty(key);
  }

  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

  }

  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
      throws BeansException {
    
  }

}
