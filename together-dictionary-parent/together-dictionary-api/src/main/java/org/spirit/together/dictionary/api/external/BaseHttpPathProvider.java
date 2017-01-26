package org.spirit.together.dictionary.api.external;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.utils.PropertyUtils;
import org.spirit.framework.core.utils.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.BasePathProvider.java
 * @Description   : qiudequan Http路径提供者
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午1:07:37 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public abstract class BaseHttpPathProvider {
  protected Logger logger = LoggerFactory.getLogger(getClass());
  /** 服务URL */
  protected String url;
  /** 服务配置Key标识 */
  protected String configKey;
  
  public BaseHttpPathProvider() {}
  
  public BaseHttpPathProvider(String configKey) {
    this.configKey = configKey;
  }
  
  /**
   *  @Description	: qiudequan 获取url(读取相应配置的值)
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:59:59 
   *  @Author         : qiudequan
   */
  protected String getUrl() {
    if (StringUtils.isEmpty(this.configKey)) {
      this.url = PropertyUtils.getProperty(this.configKey);
    }
    return this.url;
  }
  
  /**
   *  @Description	: qiudequan 生成path
   *  @param          : @return
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:11:28 
   *  @Author         : qiudequan
   */
  public String generatePath(BaseHttpPathApi pathApi, String... params) {
    Assert.notNull(pathApi, "No path mapping!");
    // 若是路径中无参数则直接返回拼接后的路径
    if(CollectionUtils.isEmpty(pathApi.getParams())) {
      return getUrl() + pathApi.getPath();
    }
    
    logger.info("path params : [{}]", Arrays.toString(params));
    Assert.notEmpty(params, "path params is empty!");
    
    // 判断路径参数是否与传递的参数值个数一致
    if(pathApi.getParams().size() != params.length) {
      logger.error("The path parameters are not consistent with the number of path parameter values, parameters size : [{}], parameter values size : [{}]",
          pathApi.getParams().size(), params.length);
      throw new IllegalArgumentException("Request parameter is not consistent!");
    }
    
    // 获取路径参数替换为具体值后的真实路径
    String realPath = repalceParameters(pathApi, params);
    return realPath;
  }

  /**
   *  @Description	: qiudequan 替换参数位为具体的值
   *  @param          : @param pathApi
   *  @param          : @param params
   *  @param          : @return 替换后url
   *  @return         : String
   *  @Creation Date  : 2016年12月11日 下午1:58:44 
   *  @Author         : qiudequan
   */
  private String repalceParameters(BaseHttpPathApi pathApi, String[] params) {
    String path = getUrl() + pathApi.getPath();
    for (int i = 0; i < params.length; i++) {
      path = path.replaceAll("\\{" + pathApi.getParams().get(i) + "\\}", params[i]);
    }
    return path;
  }
}
