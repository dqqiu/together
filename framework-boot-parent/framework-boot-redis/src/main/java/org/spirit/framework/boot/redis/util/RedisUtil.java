package org.spirit.framework.boot.redis.util;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings(value = {"rawtypes", "unchecked"})
public class RedisUtil {
  
  @Autowired
  private RedisTemplate redisTemplate;
  
  /**
   *  @Description	: qiudequan 根据key获取缓存对象
   *  @return         : Object
   *  @Creation Date  : 2016年10月19日 下午4:18:54 
   *  @Author         : qiudequan
   */
  public Object get(final String key) {
    ValueOperations<Serializable, Object> opt = redisTemplate.opsForValue();
    return opt.get(key);
  }
  
  /**
   *  @Description	: qiudequan 写入缓存
   *  @return         : boolean
   *  @Creation Date  : 2016年10月16日 下午9:51:02 
   *  @Author         : qiudequan
   */
  public boolean set(final String key, Object value) {
    boolean result = false;
    try {
      ValueOperations<Serializable, Object> opt = redisTemplate.opsForValue();
      opt.set(key, value);
      result = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
  
  /**
   *  @Description	: qiudequan 写入缓存,可设置过期时间(单位：秒)
   *  @return         : boolean
   *  @Creation Date  : 2016年10月16日 下午9:52:41 
   *  @Author         : qiudequan
   */
  public boolean setex(final String key, Object value, Long expireTime) {
    boolean result = false;
    try {
      ValueOperations<Serializable, Object> opt = redisTemplate.opsForValue();
      opt.set(key, value);
      redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
      result = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
  
  /**
   *  @Description	: qiudequan 判断缓存中是否存在指定key
   *  @return         : boolean
   *  @Creation Date  : 2016年10月16日 下午9:55:45 
   *  @Author         : qiudequan
   */
  public boolean exists(final String key) {
    return redisTemplate.hasKey(key);
  }
  
  /**
   *  @Description	: qiudequan 删除缓存
   *  @return         : void
   *  @Creation Date  : 2016年10月16日 下午9:57:08 
   *  @Author         : qiudequan
   */
  public void remove(final String key) {
    if(exists(key)) {
      redisTemplate.delete(key);
    }
  }
  
  /**
   *  @Description	: qiudequan 批量删除缓存
   *  @return         : void
   *  @Creation Date  : 2016年10月16日 下午9:58:56 
   *  @Author         : qiudequan
   */
  public void removePattern(final String pattern) {
    Set<Serializable> keys = redisTemplate.keys(pattern);
    if(keys.size() > 0) {
      redisTemplate.delete(keys);
    }
  }
  
  /**
   *  @Description	: qiudequan 批量删除缓存
   *  @return         : void
   *  @Creation Date  : 2016年10月16日 下午10:00:03 
   *  @Author         : qiudequan
   */
  public void remove(final String... keys) {
    for (int i = 0; i < keys.length; i++) {
      remove(keys[i]);
    }
  }
}
