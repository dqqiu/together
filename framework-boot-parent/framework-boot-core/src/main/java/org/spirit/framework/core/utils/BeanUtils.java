package org.spirit.framework.core.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.exceptions.InternalServerException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.utils.BeanUtils.java
 * @Description   : qiudequan Bean工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午1:37:49 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public abstract class BeanUtils extends org.springframework.beans.BeanUtils {

  private static final ConcurrentMap<String, HashMap<String, String>> fieldNameCache =
      new ConcurrentHashMap<>();

  private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

  /**
   *  @Description	: qiudequan 拷贝属性（忽略类型不一致而名称相同的属性）
   *  @param          : @param source
   *  @param          : @param target
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午1:38:02 
   *  @Author         : qiudequan
   */
  public static void copy(Object source, Object target) {
    copy(source, target, true);
  }

  /**
   *  @Description	: qiudequan 拷贝属性（忽略类型不一致的属性），指定ignoreNull参数是否忽略为null的属性
   *  @param          : @param source
   *  @param          : @param target
   *  @param          : @param ignoreNull
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 下午1:38:14 
   *  @Author         : qiudequan
   */
  public static void copy(Object source, Object target, boolean ignoreNull) {
    BeanWrapper sourceBean = new BeanWrapperImpl(source);
    BeanWrapper targetBean = new BeanWrapperImpl(target);
    PropertyDescriptor[] targetProperties = getPropertyDescriptors(target.getClass());
    for (PropertyDescriptor property : targetProperties) {
      Class<?> targetType = property.getPropertyType();
      String name = property.getName();
      PropertyDescriptor sourceProperty = getPropertyDescriptor(source.getClass(), name);
      if (sourceProperty == null)
        continue;
      Object propertyVal = sourceBean.getPropertyValue(property.getName());
      if (!targetType.equals(sourceProperty.getPropertyType()) || "class".equals(property.getName())
          || (ignoreNull && propertyVal == null))
        continue;
      targetBean.setPropertyValue(property.getName(),
          sourceBean.getPropertyValue(property.getName()));
    }
  }

  /**
   *  @Description	: qiudequan 获取目标对象的所有属性列表
   *  @param          : @param target
   *  @param          : @return
   *  @return         : Map<String,String>
   *  @Creation Date  : 2016年12月11日 下午1:38:25 
   *  @Author         : qiudequan
   */
  public static Map<String, String> getFieldNames(Object target) {
    if (target == null)
      return null;
    HashMap<String, String> fieldNames = null;
    fieldNames = fieldNameCache.get(target.getClass().getName());
    if (!CollectionUtils.isEmpty(fieldNames))
      return fieldNames;
    fieldNames = new HashMap<>();
    PropertyDescriptor[] targetProperties = getPropertyDescriptors(target.getClass());
    for (PropertyDescriptor property : targetProperties) {
      if ("class".equals(property.getName()))
        continue;
      fieldNames.put(property.getName(), property.getName());
    }
    fieldNameCache.putIfAbsent(target.getClass().getName(), fieldNames);
    return fieldNames;
  }

  /**
   *  @Description	: qiudequan 将对象转为Map
   *  @param          : @param target
   *  @param          : @return
   *  @return         : Map<String,Object>
   *  @Creation Date  : 2016年12月11日 下午1:38:34 
   *  @Author         : qiudequan
   */
  public static Map<String, Object> toMap(Object target) {
    return toMap(target, null, false);
  }

  public static Map<String, Object> toMap(Object target, boolean isNull) {
    return toMap(target, null, isNull);
  }

  /**
   *  @Description	: qiudequan 将目标对象target转为Map格式,但将excludeProperties集合指定的属性排除在外
   *  @param          : @param target
   *  @param          : @param excludeProperties
   *  @param          : @param isNull
   *  @param          : @return
   *  @return         : Map<String,Object>
   *  @Creation Date  : 2016年12月11日 下午1:38:44 
   *  @Author         : qiudequan
   */
  public static Map<String, Object> toMap(Object target, List<String> excludeProperties,
      boolean isNull) {
    if (target == null)
      throw new RuntimeException("对象不能为空！");
    BeanWrapper bean = new BeanWrapperImpl(target);
    PropertyDescriptor[] targetProperties = BeanUtils.getPropertyDescriptors(target.getClass());
    Map<String, Object> map = new HashMap<String, Object>();
    for (PropertyDescriptor property : targetProperties) {
      Object propetyValue = bean.getPropertyValue(property.getName());
      if (isNull && propetyValue == null) {
        map.put(property.getName(), "");
        continue;
      }
      if (propetyValue == null || isExcludeProperty(excludeProperties, property.getName()))
        continue;
      if (propetyValue instanceof String) { // 处理字符串类型
        if (StringUtils.hasText(propetyValue.toString())) {
          propetyValue = propetyValue.toString().trim();
        } else {
          continue;
        }
      }
      map.put(property.getName(), propetyValue);
    }
    return map;
  }

  /**
   *  @Description	: qiudequan 是否排除该属性
   *  @param          : @param excludeProperties
   *  @param          : @param propertyName
   *  @param          : @return
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午1:38:53 
   *  @Author         : qiudequan
   */
  private static boolean isExcludeProperty(List<String> excludeProperties, String propertyName) {

    if ("class".equals(propertyName)) // 如果当前属性名称等于class,则排除
      return true;

    if (CollectionUtils.isEmpty(excludeProperties))
      return false;

    for (String property : excludeProperties) { // 如果当前属性名称在可排除集合之内,则返回true
      if (property.equals(propertyName))
        return true;
    }
    return false;
  }

  public static NameValuePair[] toFormParam(Object source) throws Exception {
    return toFormParam(source, null);
  }

  public static NameValuePair[] toFormParam(Object source, String[] excludeProperties)
      throws Exception {
    BeanWrapper sourceBean = new BeanWrapperImpl(source);
    PropertyDescriptor[] properties = getPropertyDescriptors(source.getClass());
    ArrayList<NameValuePair> result = new ArrayList<NameValuePair>();
    for (PropertyDescriptor property : properties) {
      Object propetyValue = sourceBean.getPropertyValue(property.getName());
      if (propetyValue == null)
        continue;
      if (propetyValue instanceof String) { // 处理字符串类型
        if (StringUtils.hasText(propetyValue.toString())) {
          propetyValue = propetyValue.toString().trim();
        } else {
          continue;
        }
      }
      result.add(new BasicNameValuePair(property.getName(), propetyValue.toString()));
    }
    if (!CollectionUtils.isEmpty(result)) {
      NameValuePair[] names = new NameValuePair[result.size()];
      for (int i = 0; i < result.size(); i++) {
        names[i] = result.get(i);
      }
      return names;
    }
    return null;
  }

  /**
   *  @Description	: qiudequan 将表对象转为get请求参数
   *  @param          : @param target
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:39:02 
   *  @Author         : qiudequan
   */
  public static String toRequestByGet(Object target) {
    if (target == null)
      return null;
    BeanWrapper sourceBean = new BeanWrapperImpl(target);
    PropertyDescriptor[] properties = getPropertyDescriptors(target.getClass());
    StringBuilder builder = new StringBuilder();
    boolean flag = false;
    for (int i = 0; i < properties.length; i++) {
      PropertyDescriptor property = properties[i];
      Object propetyValue = sourceBean.getPropertyValue(property.getName());
      if (propetyValue == null || property.getName().equals("class"))
        continue;

      if (propetyValue instanceof String) // 处理字符串类型
        if (StringUtils.hasText(propetyValue.toString()))
          propetyValue = propetyValue.toString().trim();
      if (propetyValue.getClass().equals(Date.class))
        propetyValue = DateUtils.getFormatTime((Date) propetyValue, DateUtils.DATE_HH_MM_SS);
      builder.append(!flag ? "?" : "&").append(property.getName()).append("=")
          .append(propetyValue.toString());
      flag = true;
    }
    return builder.toString();
  }

  /**
   *  @Description	: qiudequan 检测属性fieldName在对象target所属的类中是否存在
   *  @param          : @param target
   *  @param          : @param fieldName
   *  @param          : @return 如果存在返回true,否则返回false
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午1:39:15 
   *  @Author         : qiudequan
   */
  public static boolean isFieldExist(Object target, String fieldName) {
    if (target == null)
      throw new InternalServerException("target 不能为空！");
    Map<String, String> fieldNames = getFieldNames(target);
    return !CollectionUtils.isEmpty(fieldNames) && StringUtils.hasText(fieldNames.get(fieldName));
  }

  /**
   *  @Description	: qiudequan 属性注入,如果成功返回true,否则返回false
   *  @param          : @param target
   *  @param          : @param fieldName
   *  @param          : @param value
   *  @param          : @return
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午1:39:35 
   *  @Author         : qiudequan
   */
  public static boolean injectionField(Object target, String fieldName, Object value) {
    if (target == null)
      throw new InternalServerException("target 不能为空！");
    if (StringUtils.isEmpty(fieldName))
      throw new InternalServerException("fieldName 不能为空！");
    if (value == null)
      throw new InternalServerException("value 不能为空！");
    // 检测该字段是否存在于对象target中
    if (!BeanUtils.isFieldExist(target, fieldName))
      return false;
    // 将值value注入对象target的fieldName字段
    new BeanWrapperImpl(target).setPropertyValue(fieldName, value);
    return true;
  }

  /**
   *  @Description	: qiudequan 获取目标对象指定属性的值
   *  @param          : @param target
   *  @param          : @param propertyName
   *  @param          : @return
   *  @return         : Object
   *  @Creation Date  : 2016年12月11日 下午1:39:44 
   *  @Author         : qiudequan
   */
  public static Object getPropertyValue(Object target, String propertyName) {
    if (target == null)
      throw new InternalServerException("target 不能为空！");
    if (StringUtils.isEmpty(propertyName))
      throw new InternalServerException("propertyName 不能为空！");
    // 检测该字段是否存在于对象target中
    if (!BeanUtils.isFieldExist(target, propertyName))
      return null;
    return new BeanWrapperImpl(target).getPropertyValue(propertyName);
  }

  /**
   *  @Description	: qiudequan 判断一个对象是否为空；首先这个对象不能空,并且对象中的属性至少有一个不为空,则认为这个对象不为空，返回true, 否则返回false
   *  @param          : @param target
   *  @param          : @return
   *  @return         : boolean
   *  @Creation Date  : 2016年12月11日 下午1:39:54 
   *  @Author         : qiudequan
   */
  public static boolean isEmpty(Object target) {
    return !isNotEmpty(target);
  }

  public static boolean isNotEmpty(Object target) {
    if (target == null) {
      return false;
    }
    BeanWrapper targetBean = new BeanWrapperImpl(target);
    PropertyDescriptor[] targetProperties = getPropertyDescriptors(target.getClass());
    for (PropertyDescriptor property : targetProperties) {
      Object propertyVal = targetBean.getPropertyValue(property.getName());
      if ("class".equals(property.getName()))
        continue;
      // 如果属性不为空,且属性类型为字符串类型且为有效字符串时，返回true
      if (propertyVal != null
          && (propertyVal instanceof String && StringUtils.hasText((CharSequence) propertyVal)))
        return true;
      // 否则属性不为空,返回true,否则返回false
      if (propertyVal != null && !(propertyVal instanceof String))
        return true;
    }
    return false;
  }

  /**
   *  @Description	: qiudequan 重写toString()方法
   *  @param          : @param target
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:40:06 
   *  @Author         : qiudequan
   */
  public static String toString(Object target) {
    if (target == null)
      return "";
    try {
      BeanWrapper targetBean = new BeanWrapperImpl(target);
      PropertyDescriptor[] targetProperties = getPropertyDescriptors(target.getClass());
      StringBuilder builder = new StringBuilder();
      builder.append(target.getClass().getName()).append(":[");
      for (PropertyDescriptor property : targetProperties) {
        String name = property.getName();
        PropertyDescriptor targetProperty = getPropertyDescriptor(target.getClass(), name);
        if (targetProperty == null || "class".equals(name))
          continue;
        Object propertyVal = targetBean.getPropertyValue(name);
        builder.append(name).append(":").append(propertyVal == null ? "" : propertyVal).append(",");
      }
      builder.append("]");
      return builder.toString();
    } catch (BeansException e) {
      logger.warn("打印目标对象的值失败!", e);
    }
    return "";
  }

}
