package org.spirit.together.dictionary.api.external;

import org.spirit.together.dictionary.api.model.DictData;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.DictionaryBaseHttpApi.java
 * @Description   : qiudequan 数据字典通用API接口
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午12:18:47 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public interface DictDataHttpApi {
  /**
   *  @Description	: qiudequan 根据Code获取字典数据
   *  @param          : @param code
   *  @param          : @return
   *  @return         : V
   *  @Creation Date  : 2016年12月11日 下午12:20:42 
   *  @Author         : qiudequan
   */
  DictData getDictDataByCode(String code, String dictDataTypeCd);
}
