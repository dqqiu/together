package org.spirit.framework.boot.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "together.page")
public class PageProperties {
  private String pageNoName = "pageNo";
  private String pageSizeName = "pageSize";
  private Integer pageNo = 1;
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
  public Integer getPageNo() {
    return pageNo;
  }
  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  
}   
