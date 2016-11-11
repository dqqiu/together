package org.spirit.together.dictionary.api.vo;

import java.lang.Long;
import java.lang.String;
import java.util.Date;

/**
 *	
 * @created by mapper-generate
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public class DictStateVo {
  /**
   * 字段：cd. 类型：VARCHAR(20). 备注：国家CD.
   */
  private String cd;

  /**
   * 字段：dscp. 类型：VARCHAR(50). 备注：国家.
   */
  private String dscp;

  /**
   * 字段：is_del. 类型：VARCHAR(1). 备注：是否删除，Y：已删除，N：未删除(默认).
   */
  private String isDel;

  /**
   * 字段：created_by. 类型：VARCHAR(50). 备注：创建人.
   */
  private String createdBy;

  /**
   * 字段：updated_by. 类型：VARCHAR(50). 备注：修改人.
   */
  private String updatedBy;

  /**
   * 字段：create_time. 类型：DATETIME(19). 备注：创建时间.
   */
  private Date createTime;
  /**
   * 备注：创建时间--开始时间,查询用
   */
  private Date createTimeBegin;
  /**
   * 备注：创建时间--结束时间,查询用
   */
  private Date createTimeEnd;

  /**
   * 字段：update_time. 类型：DATETIME(19). 备注：最后一次更新时间.
   */
  private Date updateTime;
  /**
   * 备注：最后一次更新时间--开始时间,查询用
   */
  private Date updateTimeBegin;
  /**
   * 备注：最后一次更新时间--结束时间,查询用
   */
  private Date updateTimeEnd;

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


  public void setIsDel(String isDel) {
    this.isDel = isDel;
  }

  public String getIsDel() {
    return this.isDel;
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


  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return this.createTime;
  }
  public void setCreateTimeBegin(Date createTimeBegin) {
    this.createTimeBegin = createTimeBegin;
  }

  public Date getCreateTimeBegin() {
    return this.createTimeBegin;
  }

  public void setCreateTimeEnd(Date createTimeEnd) {
    this.createTimeEnd = createTimeEnd;
  }

  public Date getCreateTimeEnd() {
    return this.createTimeEnd;
  }


  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getUpdateTime() {
    return this.updateTime;
  }
  public void setUpdateTimeBegin(Date updateTimeBegin) {
    this.updateTimeBegin = updateTimeBegin;
  }

  public Date getUpdateTimeBegin() {
    return this.updateTimeBegin;
  }

  public void setUpdateTimeEnd(Date updateTimeEnd) {
    this.updateTimeEnd = updateTimeEnd;
  }

  public Date getUpdateTimeEnd() {
    return this.updateTimeEnd;
  }


  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getVersion() {
    return this.version;
  }

}