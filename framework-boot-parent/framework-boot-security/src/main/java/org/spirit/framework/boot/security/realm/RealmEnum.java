package org.spirit.framework.boot.security.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.realm.Realm;
import org.spirit.framework.core.utils.BeanFactoryUtils;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.realm.RealmEnum.java
 * @Description   : qiudequan Realm枚举
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午10:24:42 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public enum RealmEnum {
  USERNAME_PASSWORD_REALM(UsernamePasswordRealm.class, "基于用户名密码的Realm");

  private String desc;

  private Class<? extends Realm> realm;

  private RealmEnum(Class<? extends Realm> realm, String desc) {
    this.realm = realm;
    this.desc = desc;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  /**
   *  @Description	: qiudequan 获取所有注册的Realm
   *  @param          : @return
   *  @return         : List<Realm>
   *  @Creation Date  : 2016年12月3日 下午10:57:36 
   *  @Author         : qiudequan
   */
  public static List<Realm> getRealms() {
    List<Realm> realms = new ArrayList<Realm>();
    RealmEnum[] values = RealmEnum.values();
    if(ArrayUtils.isNotEmpty(values)) {
      for (RealmEnum realmEnum : values) {
        Realm realm = BeanFactoryUtils.getBean(realmEnum.realm);
        if(realm != null){
          realms.add(realm);
        }
      }
    }
    return realms;
  }

}
