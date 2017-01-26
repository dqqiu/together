package org.spirit.together.dictionary.translate.registry.support;

import org.spirit.framework.core.utils.ApplicationContextUtils;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourceMapping;
import org.spirit.together.dictionary.translate.registry.DictionaryRemotingResourcesRegistry;
import org.spirit.together.dictionary.translate.resources.remoting.DictStateRemotingResource;
import org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.support.remoting.DictionaryRemotingRegistry.java
 * @Description   : qiudequan 远程资源注册器
 * @Author        : qiudequan
 * @Creation Date : 2016年12月10日 下午8:45:30 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月10日        create
 */
public enum ExplicitRemotingRegistry implements DictionaryRemotingResourcesRegistry, DictionaryRemotingResourceMapping {
  MT_STATE("mtStateCd", "mt_state表远程资源映射", DictStateRemotingResource.class)
  ;

  private String code;
  
  private String desc;
  
  private Class<? extends DictionaryRemotingAccessor> type;
  
  private DictionaryRemotingAccessor accessor;
  
  private ExplicitRemotingRegistry(String code, String desc, Class<? extends DictionaryRemotingAccessor> type) {
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
