package org.spirit.framework.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.ApplicationContextUtils.java
 * @Description   : qiudequan spring应用上下文工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午5:28:49 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }

  /**
   *  @Description	: qiudequan 根据bean名称获取bean
   *  @param          : @param name
   *  @param          : @return
   *  @param          : @throws BeansException
   *  @return         : T
   *  @Creation Date  : 2016年12月11日 下午5:29:13 
   *  @Author         : qiudequan
   */
  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) throws BeansException {
    return (T) context.getBean(name);
  }

  /**
   *  @Description	: qiudequan 获取类型为requiredType的对象
   *  @param          : @param clz
   *  @param          : @return
   *  @param          : @throws BeansException
   *  @return         : T
   *  @Creation Date  : 2016年12月11日 下午5:29:21 
   *  @Author         : qiudequan
   */
  public static <T> T getBean(Class<T> clz) throws BeansException {
    return (T) context.getBean(clz);
  }

  /**
   *  @Description	: qiudequan 如果ApplicationContext包含一个与所给名称匹配的bean定义，则返回true
   *  @param          : @param name
   *  @param          : @return
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午5:29:50 
   *  @Author         : qiudequan
   */
  public static boolean containsBean(String name) {
    return context.containsBean(name);
  }

  /**
   *  @Description	: qiudequan 判断以给定名字注册的bean定义是一个singleton还是一个prototype
   *  @param          : @param name
   *  @param          : @return
   *  @param          : @throws NoSuchBeanDefinitionException
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午5:30:05 
   *  @Author         : qiudequan
   */
  public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
    return context.isSingleton(name);
  }

  /**
   *  @Description	: qiudequan 注册对象的类型
   *  @param          : @param name
   *  @param          : @return
   *  @param          : @throws NoSuchBeanDefinitionException
   *  @return         : Class<?>
   *  @Creation Date  : 2016年12月11日 下午5:30:15 
   *  @Author         : qiudequan
   */
  public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
    return context.getType(name);
  }

  /**
   *  @Description	: qiudequan 如果给定的bean名字在bean定义中有别名，则返回这些别名
   *  @param          : @param name
   *  @param          : @return
   *  @param          : @throws NoSuchBeanDefinitionException
   *  @return         : String[]
   *  @Creation Date  : 2016年12月11日 下午5:30:24 
   *  @Author         : qiudequan
   */
  public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
    return context.getAliases(name);
  }

}
