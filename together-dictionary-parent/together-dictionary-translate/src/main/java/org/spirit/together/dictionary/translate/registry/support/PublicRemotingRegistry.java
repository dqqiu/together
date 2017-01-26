package org.spirit.together.dictionary.translate.registry.support;

import org.spirit.framework.core.utils.ApplicationContextUtils;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourceMapping;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourcesRegistry;
import org.spirit.together.dictionary.translate.resources.AbstractRemotingResourceWrapper;
import org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor;
import org.spirit.together.dictionary.translate.resources.remoting.MtDataRemotingResource;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.support.remoting.PublicRemotingRegistry.java
 * @Description   : qiudequan 公用字典远程资源注册器
 * @Author        : qiudequan
 * @Creation Date : 2016年12月10日 下午8:55:37 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月10日        create
 */
public enum PublicRemotingRegistry implements DictionaryRemotingResourcesRegistry, DictionaryRemotingResourceMapping {
  MT_DATA("mt_data", "mt_data表远程资源映射", MtDataRemotingResource.class);
  
  
  private String code;
  private String desc;
  private Class<? extends DictionaryRemotingAccessor> type;
  private DictionaryRemotingAccessor accessor;
  
  private PublicRemotingRegistry(String code, String desc, Class<? extends DictionaryRemotingAccessor> type) {
    this.code = code;
    this.desc = desc;
    this.type = type;
  }

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }

  public DictionaryRemotingResourcesRegistry getRegistry() {
    return this;
  }

  public DictionaryRemotingAccessor getRemotingAccessor() {
    if (this.accessor == null) {
      this.accessor = ApplicationContextUtils.getBean(this.type);
      if (this.accessor != null)
        this.accessor.setKey(this.code);
    }
    return this.accessor;
  }
}
