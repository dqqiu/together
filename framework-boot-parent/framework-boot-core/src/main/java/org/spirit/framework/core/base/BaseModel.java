package org.spirit.framework.core.base;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.base.BaseModel.java
 * @Description   : TODO qiudequan 基类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月14日 上午10:55:23 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月14日        create
 */
public class BaseModel {
  private String createdBy;
  private String updatedBy;
  private Long createTime;
  private Long updateTime;
  private String isDel;
  private Long version;
  
  public String getCreatedBy() {
    return createdBy;
  }
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }
  public String getUpdatedBy() {
    return updatedBy;
  }
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }
  public Long getCreateTime() {
    return createTime;
  }
  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }
  public Long getUpdateTime() {
    return updateTime;
  }
  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }
  public String getIsDel() {
    return isDel;
  }
  public void setIsDel(String isDel) {
    this.isDel = isDel;
  }
  public Long getVersion() {
    return version;
  }
  public void setVersion(Long version) {
    this.version = version;
  }
  
  
}
