package org.spirit.together.dictionary.translate.resources;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.together.dictionary.api.model.DictBaseModel;
import org.spirit.together.dictionary.translate.meta.DictionaryMeta;
import org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.resources.AbstractRemotingResourceWrapper.java
 * @Description   : qiudequan 远程资源包装器
 * @Author        : qiudequan
 * @Creation Date : 2016年12月10日 下午9:05:28 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月10日        create
 */
public abstract class AbstractRemotingResourceWrapper<V extends DictBaseModel> implements DictionaryRemotingAccessor {
  protected final Logger logger = LoggerFactory.getLogger(getClass());
  
  private String key;
  
  /**
   *  @Description	: qiudequan 获取需要翻译的所有code
   *  @param          : @param dictionaryMetas
   *  @param          : @return
   *  @return         : String[]
   *  @Creation Date  : 2016年12月11日 上午11:56:19 
   *  @Author         : qiudequan
   */
  protected String[] getCodes(Map<String, DictionaryMeta> dictionaryMetas) {
    String[] codes = new String[dictionaryMetas.size()];
    int index = 0;
    for (Entry<String, DictionaryMeta> metaEntry : dictionaryMetas.entrySet()) {
      codes[index] = (String) metaEntry.getValue().getCdValue();
      index++;
    }
    return codes;
  }
  
  /**
   *  @Description	: qiudequan 设置释义
   *  @param          : @param meta
   *  @param          : @param requestMeta
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 上午11:50:17 
   *  @Author         : qiudequan
   */
  protected abstract void setCodeDscp(DictBaseModel meta, Map<String, DictionaryMeta> requestMetas);
  
  /**
   *  @Description	: qiudequan 设置释义
   *  @param          : @param values
   *  @param          : @param requestMeta
   *  @return         : void
   *  @Creation Date  : 2016年12月11日 上午11:50:28 
   *  @Author         : qiudequan
   */
  protected abstract void setCodeDscp(List<V> values, Map<String, DictionaryMeta> requestMetas);

  public String setKey(String key) {
    return this.key = key;
  }

  public String getKey() {
    return this.key;
  }
  
  
  
}
