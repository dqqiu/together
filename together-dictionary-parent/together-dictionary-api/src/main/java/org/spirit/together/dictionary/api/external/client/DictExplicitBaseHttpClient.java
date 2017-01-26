package org.spirit.together.dictionary.api.external.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.http.callback.support.ComplexCallback;
import org.spirit.together.dictionary.api.external.DictExplicitBaseHttpApi;
import org.spirit.together.dictionary.api.external.DictionaryHttpPath;
import org.spirit.together.dictionary.api.external.DictionaryPathProvider;
import org.spirit.together.dictionary.api.model.DictBaseModel;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.client.DictExplicitBaseHttpClient.java
 * @Description   : qiudequan 具有明确释义的字典远程客户端
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午3:16:56 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public abstract class DictExplicitBaseHttpClient<V extends DictBaseModel> extends DictionaryPathProvider
    implements DictExplicitBaseHttpApi<V>{

  final Logger logger = LoggerFactory.getLogger(getClass());

  /** 根据code查询的数据字典http路径 */
  protected DictionaryHttpPath getDictByCodePath;
  /** 根据codes查询数据字典的http路径 */
  protected DictionaryHttpPath getDictByCodesPath;

  public DictExplicitBaseHttpClient(DictionaryHttpPath getDictByCodePath, DictionaryHttpPath getDictByCodesPath) {
    this.getDictByCodePath = getDictByCodePath;
    this.getDictByCodesPath = getDictByCodesPath;
  }

  protected abstract ComplexCallback<V> getComplexCallback();

  protected abstract ComplexCallback<List<V>> getComplexListCallback();

  public V getDictByCode(String code) {
    return OkHttpUtils.get(generatePath(getDictByCodePath, code))
        .execute(getComplexCallback());
  }

  public List<V> getDictByCodes(String[] codes) {
    return OkHttpUtils.get(generatePath(getDictByCodesPath))
        .addParam("cds", Arrays.asList(codes)).execute(getComplexListCallback());
  }

}
