package org.spirit.together.dictionary.api.external;

import java.util.List;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.DictExplicitBaseHttpApi.java
 * @Description   : qiudequan 具有明确释义的数据字典的远程接口API
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午3:31:08 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public interface DictExplicitBaseHttpApi<V> {
  /**
   *  @Description	: qiudequan 根据code获取数据字典
   *  @param          : @param code
   *  @param          : @return
   *  @return         : V
   *  @Creation Date  : 2016年12月11日 下午3:30:51 
   *  @Author         : qiudequan
   */
  V getDictByCode(String code);
  
  /**
   *  @Description	: qiudequan 根据code数组获取数据字典
   *  @param          : @param codes
   *  @param          : @return
   *  @return         : List<V>
   *  @Creation Date  : 2016年12月11日 下午3:31:59 
   *  @Author         : qiudequan
   */
  List<V> getDictByCodes(String[] codes);
}
