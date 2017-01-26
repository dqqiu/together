package org.spirit.together.dictionary.api.model;

import java.lang.Long;
import java.lang.String;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public class DictType implements DictBaseModel {
  /**
   * 字段：cd. 类型：VARCHAR(50). 备注：字典类型CD.
   */
  private String cd;

  /**
   * 字段：dscp. 类型：VARCHAR(100). 备注：字典类型描述.
   */
  private String dscp;

  /**
   * 字段：created_by. 类型：VARCHAR(50). 备注：创建人.
   */
  private String createdBy;

  /**
   * 字段：updated_by. 类型：VARCHAR(50). 备注：修改人.
   */
  private String updatedBy;

  /**
   * 字段：create_time. 类型：BIGINT(15, 0). 备注：创建时间.
   */
  private Long createTime;

  /**
   * 字段：update_time. 类型：BIGINT(15, 0). 备注：最近一次更新时间.
   */
  private Long updateTime;

  /**
   * 字段：is_del. 类型：VARCHAR(1). 备注：是否删除，Y：已删除，N：未删除(默认).
   */
  private String isDel;

  /**
   * 字段：version. 类型：BIGINT(15, 0). 备注：版本号.
   */
  private Long version;



  public void setCd(String cd) {
    this.cd = cd;
  }

  public String getCd() {
    return this.cd;
  }


  public void setDscp(String dscp) {
    this.dscp = dscp;
  }

  public String getDscp() {
    return this.dscp;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }


  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public String getUpdatedBy() {
    return this.updatedBy;
  }


  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public Long getCreateTime() {
    return this.createTime;
  }


  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public Long getUpdateTime() {
    return this.updateTime;
  }


  public void setIsDel(String isDel) {
    this.isDel = isDel;
  }

  public String getIsDel() {
    return this.isDel;
  }


  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getVersion() {
    return this.version;
  }

}