package org.spirit.framework.boot.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.properties.AppProperties.java
 * @Description   : qiudequan 应用自定义属性类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月1日 下午12:27:48 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月1日        create
 */
@Component
@ConfigurationProperties(prefix = "together.app")
public class AppProperties {
  /** 应用名称 */
  private String name;
  /** 应用部署机器域名/IP */
  private String host;
  /** 应用占用端口号 */
  private String port;
  /** 应用版本号 */
  private String version;
  /** 应用访问路径 */
  private String path;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getHost() {
    return host;
  }
  public void setHost(String host) {
    this.host = host;
  }
  public String getPort() {
    return port;
  }
  public void setPort(String port) {
    this.port = port;
  }
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }
  public String getPath() {
    return path;
  }
  public void setPath(String path) {
    this.path = path;
  }
}
