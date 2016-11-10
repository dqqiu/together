package org.spirit.framework.boot.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.properties.MybatisProperties.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月9日 下午4:56:21 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月9日        create
 */
@Component
@ConfigurationProperties(prefix = "together.mybatis")
public class MybatisProperties {
  private String mapperLocations;
  private String mapperScanPackages;
  public String getMapperLocations() {
    return mapperLocations;
  }
  public void setMapperLocations(String mapperLocations) {
    this.mapperLocations = mapperLocations;
  }
  public String getMapperScanPackages() {
    return mapperScanPackages;
  }
  public void setMapperScanPackages(String mapperScanPackages) {
    this.mapperScanPackages = mapperScanPackages;
  }
  
}
