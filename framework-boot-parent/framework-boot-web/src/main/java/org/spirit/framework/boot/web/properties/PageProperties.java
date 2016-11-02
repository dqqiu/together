package org.spirit.framework.boot.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "together.page")
public class PageProperties {
  /** 当前页参数名,默认值:pageNo */
  private String pageNoName = "pageNo";
  /** 每页显示记录数参数名,默认值:pageSize */
  private String pageSizeName = "pageSize";
  /** 分页参数：每页显示记录数,默认值:10 */
  private Integer pageSize = 10;
  
  public String getPageNoName() {
    return pageNoName;
  }
  public void setPageNoName(String pageNoName) {
    this.pageNoName = pageNoName;
  }
  public String getPageSizeName() {
    return pageSizeName;
  }
  public void setPageSizeName(String pageSizeName) {
    this.pageSizeName = pageSizeName;
  }
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  
}   
