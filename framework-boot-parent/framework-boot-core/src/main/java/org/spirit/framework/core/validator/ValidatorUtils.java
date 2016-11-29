package org.spirit.framework.core.validator;

import static org.hamcrest.CoreMatchers.nullValue;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.utils.StringUtils;
import org.spirit.framework.core.validator.support.Length;
import org.spirit.framework.core.validator.support.NotNull;
import org.spirit.framework.core.validator.support.Pattern;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidatorUtils.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月28日 下午4:55:00 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月28日        create
 */
public class ValidatorUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUtils.class);
  public static void validate(Object object, String remark){
    ValidateMessageMap<String, StringBuilder> validateMessageMap = new ValidateMessageMap<String, StringBuilder>();
    try {
      Class<? extends Object> clz = object.getClass();
      Field[] fields = clz.getDeclaredFields();
      for (Field field : fields) {
        String fieldName = field.getName();
        // 非空校验
        if(field.isAnnotationPresent(NotNull.class)){
          String getterMethodName = getterMethodName(field.getName());
          if(checkMethodExist(object.getClass().getMethods(), getterMethodName)){
            NotNull notNull = field.getAnnotation(NotNull.class);
            Method method = clz.getMethod(getterMethodName, null);
            Object v = method.invoke(object, null);
            if(v == null){
              if(validateMessageMap.containsKey(fieldName)){
                validateMessageMap.put(fieldName, validateMessageMap.get(fieldName).append(", ").append(notNull.errMsg()));
              } else {
                validateMessageMap.put(fieldName, new StringBuilder(notNull.errMsg()));
              }
            }
          }
        }

        // 长度校验
        if(field.isAnnotationPresent(Length.class)){
          Length length = field.getAnnotation(Length.class);
          if("class java.lang.String".equals(field.getGenericType().toString())){
            String getterMethodName = getterMethodName(field.getName());
            if(checkMethodExist(object.getClass().getMethods(), getterMethodName)){
              Method method = clz.getMethod(getterMethodName, null);
              Object v = method.invoke(object, null);
              int len = String.valueOf(v).length();
              boolean flag = len >= length.min() && len <= length.max();
              if(!flag){
                if(validateMessageMap.containsKey(fieldName)){
                  validateMessageMap.put(fieldName, validateMessageMap.get(fieldName).append(", ").append(length.errMsg()));
                } else {
                  validateMessageMap.put(fieldName, new StringBuilder(length.errMsg()));
                }
              }
            }
          }
        } 

        // 正则校验
        if(field.isAnnotationPresent(Pattern.class)){
          if("class java.lang.String".equals(field.getGenericType().toString())){
            Pattern pattern = field.getAnnotation(Pattern.class);
            String getterMethodName = getterMethodName(field.getName());
            if(checkMethodExist(object.getClass().getMethods(), getterMethodName)){
              Method method = clz.getMethod(getterMethodName, null);
              Object v = method.invoke(object, null);
              String regex = pattern.regex();
              java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile(regex);
              boolean flag = pattern2.matcher(String.valueOf(v)).matches();
              if(!flag){
                if(validateMessageMap.containsKey(fieldName)){
                  validateMessageMap.put(fieldName, validateMessageMap.get(fieldName).append(", ").append(pattern.errMsg()));
                } else {
                  validateMessageMap.put(fieldName, new StringBuilder(pattern.errMsg()));
                }
              }
            }
          } else {
            if(validateMessageMap.containsKey(fieldName)){
              validateMessageMap.put(fieldName, validateMessageMap.get(fieldName).append(", ").append("Pattern注解只支持字符串类型的字段校验"));
            } else {
              validateMessageMap.put(fieldName, new StringBuilder("Pattern注解只支持字符串类型的字段校验"));
            }
          }
        }
      }

      if(MapUtils.isNotEmpty(validateMessageMap)){
        if(LOGGER.isDebugEnabled()){
          LOGGER.error("validator not passed ---> {}", validateMessageMap.toString());
        }
        throw new ValidatorException("validator not passed ---> " + validateMessageMap.toString());
      }
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException e) {
      throw new ValidatorException(validateMessageMap.toString(), e);
    }
  }

  /**
   *  @Description	: qiudequan 根据字段名称获取get方法名称
   *  @param          : @param fieldName
   *  @param          : @return
   *  @return 		: String
   *  @Creation Date  : 2016年11月29日 下午1:40:05 
   *  @Author         : qiudequan
   */
  public static String getterMethodName(String fieldName){
    if(StringUtils.isEmpty(fieldName)){
      return null;
    }
    return "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
  }

  /**
   *  @Description	: qiudequan 检查方法是否存在
   *  @param          : @param methods
   *  @param          : @param methodName
   *  @param          : @return
   *  @return 		: boolean
   *  @Creation Date  : 2016年11月29日 下午3:40:33 
   *  @Author         : qiudequan
   */
  public static boolean checkMethodExist(Method[] methods, String methodName){
    if(methods != null && methods.length > 0){
      for (Method method : methods) {
        if(methodName.equals(method.getName())){
          return true;
        }
      }
    }
    return false;
  }
}
