package org.spirit.together.dictionary.translate.resources.remoting;

import java.util.List;
import java.util.Map;

import org.spirit.together.dictionary.api.model.DictBaseModel;
import org.spirit.together.dictionary.api.vo.DictDataVo;
import org.spirit.together.dictionary.translate.meta.DictionaryMeta;
import org.spirit.together.dictionary.translate.resources.AbstractRemotingResourceWrapper;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.resources.remoting.MtDataRemotingResource.java
 * @Description   : qiudequan 通用字典远程资源
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午5:15:58 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public class MtDataRemotingResource extends AbstractRemotingResourceWrapper<DictDataVo> {

  public void remotingRequest(Map<String, DictionaryMeta> reuqestMetas) {

  }

  @Override
  protected void setCodeDscp(DictBaseModel meta,
      Map<String, DictionaryMeta> requestMetas) {

  }

  @Override
  protected void setCodeDscp(List<DictDataVo> values,
      Map<String, DictionaryMeta> requestMetas) {

  }

}
