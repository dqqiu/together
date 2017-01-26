package org.spirit.together.security.api.model;

import java.lang.String;
import java.lang.Long;
import java.util.Date;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public class SecUser {
  /**
   * 字段：id. 类型：VARCHAR(36). 备注：用户ID.
   */
  private String id;

  /**
   * 字段：user_name. 类型：VARCHAR(50). 备注：用户昵称.
   */
  private String userName;

  /**
   * 字段：real_name. 类型：VARCHAR(50). 备注：真实姓名.
   */
  private String realName;

  /**
   * 字段：password. 类型：VARCHAR(50). 备注：密码.
   */
  private String password;

  /**
   * 字段：phone. 类型：VARCHAR(11). 备注：手机号.
   */
  private String phone;

  /**
   * 字段：email. 类型：VARCHAR(100). 备注：邮箱号.
   */
  private String email;

  /**
   * 字段：status. 类型：VARCHAR(10). 备注：状态，ENABLE：启用，DISABLE：禁用.
   */
  private String status;

  /**
   * 字段：created_by. 类型：VARCHAR(50). 备注：创建人.
   */
  private String createdBy;

  /**
   * 字段：update_by. 类型：VARCHAR(50). 备注：修改人.
   */
  private String updateBy;

  /**
   * 字段：create_time. 类型：DATETIME(19). 备注：创建时间.
   */
  private Date createTime;

  /**
   * 字段：update_time. 类型：DATETIME(19). 备注：最近一次更新时间.
   */
  private Date updateTime;

  /**
   * 字段：is_del. 类型：VARCHAR(1). 备注：是否删除，Y：已删除，N：未删除.
   */
  private String isDel;

  /**
   * 字段：version. 类型：BIGINT(15, 0). 备注：版本号.
   */
  private Long version;


  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getRealName() {
    return this.realName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  public String getUpdateBy() {
    return this.updateBy;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getUpdateTime() {
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