package org.spirit.framework.core.validator;

import java.util.Date;

import org.spirit.framework.core.validator.support.Length;
import org.spirit.framework.core.validator.support.NotNull;
import org.spirit.framework.core.validator.support.Pattern;

/**
 * @Project       : framework-boot-core
 * @Program Name  : org.spirit.framework.core.validator.User.java
 * @Description   : qiudequan 类描述
 * @Author        : qiudequan
 * @Creation Date : 2016年11月29日 下午1:24:40 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月29日        create
 */
public class User {
  @NotNull(errMsg = "用户名不能为空", groups = "user")
  @Length(errMsg = "长度应为6-16位", min = 6, max = 16, groups = {"user"})
  private String userName;
  
  @NotNull(errMsg = "出生日期不能为空", groups = "user")
  @Pattern(regex = "^[0-9|-]+$", errMsg = "出生日期格式错误", groups = {"user", "other"})
  private Date date;

  @NotNull(errMsg = "ID不能为空", groups = {"user", "other"})
  private String id;
  
  @Length(groups = "user")
  private String[] plans;
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String[] getPlans() {
    return plans;
  }

  public void setPlans(String[] plans) {
    this.plans = plans;
  }
  
  
}
