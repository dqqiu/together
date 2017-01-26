package org.spirit.together.dictionary.translate.registry;

import java.util.HashMap;
import java.util.Map;

import org.spirit.framework.core.utils.StringUtils;
import org.spirit.together.dictionary.translate.meta.DictionaryMeta;
import org.spirit.together.dictionary.translate.meta.DictionaryTranslateRequestMeta;
import org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.registry.DictionaryCategory.java
 * @Description   : qiudequan 字典分类
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午6:59:38 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class DictionaryCategory {
  private DictionaryRemotingAccessor accessor;
  
  private Map<String, DictionaryMeta> categories = new HashMap<>();
  
  public DictionaryCategory(DictionaryRemotingAccessor accessor) {
    this.accessor = accessor;
  }
  
  public void add(DictionaryTranslateRequestMeta meta) {
    this.categories.put(meta.getKey(), meta);
  }
  
  public Map<String, DictionaryMeta> getCategories() {
    return categories;
  }

  @Override
  public String toString() {
    return StringUtils.append("dictionary categories : ", accessor.getKey(), "[", categories.toString(), "]");
  }

  public DictionaryRemotingAccessor getAccessor() {
    return accessor;
  }
  
}
