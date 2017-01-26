package org.spirit.together.dictionary.api.external.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.http.OkHttpUtils;
import org.spirit.framework.core.http.callback.support.ComplexCallback;
import org.spirit.together.dictionary.api.external.DictDataHttpApi;
import org.spirit.together.dictionary.api.external.DictionaryHttpPath;
import org.spirit.together.dictionary.api.external.DictionaryPathProvider;
import org.spirit.together.dictionary.api.model.DictData;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.client.DictDataHttpApiClient.java
 * @Description   : qiudequan 通用数据字典客户端
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午2:26:40 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class DictDataHttpApiClient extends DictionaryPathProvider implements DictDataHttpApi {

  @SuppressWarnings("unused")
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  private static DictDataHttpApiClient client = new DictDataHttpApiClient();
  
  private DictDataHttpApiClient() {}

  public static DictDataHttpApiClient getInstance() {
    return client;
  }
  
  /**
   * @see org.spirit.together.dictionary.api.external.DictDataHttpApi#getDictDataByCode
   */
  public DictData getDictDataByCode(String code, String dictDataTypeCd) {
    return OkHttpUtils.get(generatePath(DictionaryHttpPath.DICT_DATA_BY_CODE, dictDataTypeCd, code))
        .execute(new ComplexCallback<DictData>(){});
  }
}
