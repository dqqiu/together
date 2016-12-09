package org.spirit.framework.core.validator;

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
import org.springframework.util.Assert;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.ValidatorUtils.java
 * @Description   : qiudequan 校验工具类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月28日 下午4:55:00 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月28日        create
 */
public class ValidatorUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUtils.class);
  // 默认分组名称,未填写分组信息时，错误信息将会包裹与此分组
  public static final String DEFAULT_GROUP = "VALIDATOR_DEFAULT_GROUP";
  // Pattern注解字段类型错误信息
  public static final String PATTERN_TYPE_ERR_MSG = "Pattern注解只支持字符串类型的字段校验";
  // 同一个字段出现多个错误信息时的连接符号
  public static final String JOIN_SYMBOLS = "&";

  /**
   * 
   *  @Description	: qiudequan 校验
   *  @param          : @param object 被校验对象
   *  @param          : @param remark 备注信息,错误信息需要，供发生错误时查看
   *  @param          : @param throwValidatorException 是否抛出校验器异常
   *  @return         : void
   *  @Creation Date  : 2016年12月3日 下午3:29:01 
   *  @Author         : qiudequan
   */
  public static ValidatorResult<String, ValidatorMessageMap<String, StringBuilder>> validate(Object object, String remark, boolean throwValidatorException){
    Assert.notNull(object, "被校验对象为空");
    // 错误信息组
    ValidatorResult<String, ValidatorMessageMap<String, StringBuilder>> validatorResult = new ValidatorResult<>();
    validatorResult.setRemark(remark);
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
            Object v = invoke(clz, getterMethodName, object);
            if(v == null){
              String[] groups = notNull.groups();
              handlerErrorMsg(groups, notNull.errMsg(), fieldName, validatorResult);
            }
          }
        }

        // 长度校验
        if(field.isAnnotationPresent(Length.class)){
          Length length = field.getAnnotation(Length.class);
          if("class java.lang.String".equals(field.getGenericType().toString())){
            String getterMethodName = getterMethodName(field.getName());
            if(checkMethodExist(object.getClass().getMethods(), getterMethodName)){
              Object v = invoke(clz, getterMethodName, object);
              int len = String.valueOf(v).length();
              boolean flag = len >= length.min() && len <= length.max();
              if(!flag){
                String[] groups = length.groups();
                handlerErrorMsg(groups, length.errMsg(), fieldName, validatorResult);
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
              Object v = invoke(clz, getterMethodName, object);
              String regex = pattern.regex();
              java.util.regex.Pattern pattern2 = java.util.regex.Pattern.compile(regex);
              boolean flag = pattern2.matcher(String.valueOf(v)).matches();
              if(!flag){
                String[] groups = pattern.groups();
                handlerErrorMsg(groups, pattern.errMsg(), fieldName, validatorResult);
              }
            }
          } else {
            Pattern pattern = field.getAnnotation(Pattern.class);
            String[] groups = pattern.groups();
            handlerErrorMsg(groups, PATTERN_TYPE_ERR_MSG, fieldName, validatorResult);
          }
        }
      }

      if(MapUtils.isNotEmpty(validatorResult)){
        if(LOGGER.isDebugEnabled()){
          LOGGER.error("validator not passed ---> {}", validatorResult.toString());
        }
        if(throwValidatorException){
          throw new ValidatorException("validator not passed ---> " + validatorResult.toString());
        }
      }
    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
        | IllegalArgumentException | InvocationTargetException e) {
      throw new ValidatorException(validatorResult.toString(), e);
    }
    return validatorResult;
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

  /**
   *  @Description	: qiudequan 调用方法获取值
   *  @param          : @param clz 类
   *  @param          : @param methodName 方法名称
   *  @param          : @param obj 对象
   *  @return         : Object 调用方法所获得的结果
   *  @Creation Date  : 2016年12月3日 下午3:53:05 
   *  @Author         : qiudequan
   */
  protected static Object invoke(Class<? extends Object> clz, String methodName, Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Method method = clz.getMethod(methodName, null);
    return method.invoke(obj, null);
  }

  protected static void handlerErrorMsg(String[] groups, String errMsg, String fieldName, ValidatorResult<String, ValidatorMessageMap<String, StringBuilder>> validatorResult) {
    if(groups != null && groups.length > 0){
      for (String groupName : groups) {
        if(validatorResult.containsKey(groupName)){
          ValidatorMessageMap<String, StringBuilder> validateMessageMap2 = validatorResult.get(groupName);
          if(validateMessageMap2.containsKey(fieldName)){
            validateMessageMap2.put(fieldName, validateMessageMap2.get(fieldName).append(JOIN_SYMBOLS).append(errMsg));
          } else {
            validateMessageMap2.put(fieldName, new StringBuilder(errMsg));
          }
          validatorResult.put(groupName, validateMessageMap2);
        } else {
          ValidatorMessageMap<String, StringBuilder> messageMap = new ValidatorMessageMap<String, StringBuilder>();
          messageMap.put(fieldName, new StringBuilder(errMsg));
          validatorResult.put(groupName, messageMap);
        }
      }
    } else {
      if(validatorResult.containsKey(DEFAULT_GROUP)){
        ValidatorMessageMap<String, StringBuilder> validateMessageMap2 = validatorResult.get(DEFAULT_GROUP);
        if(validateMessageMap2.containsKey(fieldName)){
          validateMessageMap2.put(fieldName, validateMessageMap2.get(fieldName).append(JOIN_SYMBOLS).append(errMsg));
        } else {
          validateMessageMap2.put(fieldName, new StringBuilder(errMsg));
        }
        validatorResult.put(DEFAULT_GROUP, validateMessageMap2);
      } else {
        ValidatorMessageMap<String, StringBuilder> messageMap = new ValidatorMessageMap<String, StringBuilder>();
        messageMap.put(fieldName, new StringBuilder(errMsg));
        validatorResult.put(DEFAULT_GROUP, messageMap);
      }
    }
  }

}
