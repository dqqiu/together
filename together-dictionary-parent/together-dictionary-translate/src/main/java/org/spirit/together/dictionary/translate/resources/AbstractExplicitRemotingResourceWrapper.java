package org.spirit.together.dictionary.translate.resources;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.spirit.together.dictionary.api.external.DictExplicitBaseHttpApi;
import org.spirit.together.dictionary.api.external.client.DictExplicitBaseHttpClient;
import org.spirit.together.dictionary.api.model.DictBaseModel;
import org.spirit.together.dictionary.translate.meta.DictionaryMeta;
import org.spirit.together.dictionary.translate.meta.DictionaryTranslateRequestMeta;
import org.springframework.util.ObjectUtils;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.resources.DictionaryExplicitRemotingResourceWrapper.java
 * @Description   : qiudequan 具有明确释义的远程释义包装器
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 上午11:58:10 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public abstract class AbstractExplicitRemotingResourceWrapper<V extends DictBaseModel> extends AbstractRemotingResourceWrapper<V> implements DictExplicitBaseHttpApi<V>{

  protected abstract DictExplicitBaseHttpClient<V> getDictExplicitBaseHttpClient();

  public V getDictByCode(String code) {
    return getDictExplicitBaseHttpClient().getDictByCode(code);
  }

  public List<V> getDictByCodes(String[] codes) {
    return getDictExplicitBaseHttpClient().getDictByCodes(codes);
  }

  /**
   * @see org.spirit.together.dictionary.translate.resources.remoting.DictionaryRemotingAccessor#remotingRequest
   */
  public void remotingRequest(Map<String, DictionaryMeta> requestMetas) {
    if(logger.isDebugEnabled()) {
      logger.debug("request args, requestMetas : {} ", requestMetas);
    }
    String[] codes = getCodes(requestMetas);
    if(ObjectUtils.isEmpty(codes)) {
      return;
    }

    if(codes.length == 1) {
      setCodeDscp(getDictByCode(codes[0]), requestMetas);
    } else {
      setCodeDscp(getDictByCodes(codes), requestMetas);
    }
  }

  @Override
  protected void setCodeDscp(DictBaseModel meta,
      Map<String, DictionaryMeta> requestMetas) {
    if(ObjectUtils.isEmpty(meta)) {
      if(logger.isDebugEnabled()) {
        logger.debug("No result");
      }
      return;
    }

    if(StringUtils.isEmpty(meta.getDscp())) {
      if(logger.isDebugEnabled()) {
        logger.debug("No result, key : {}, cd : {}", getKey(), meta.getCd());
      }
      return;
    }

    DictionaryTranslateRequestMeta requestMeta = (DictionaryTranslateRequestMeta) requestMetas.get(getKey());
    requestMeta.setDscp(meta.getDscp());
    if(logger.isDebugEnabled()) {
      logger.debug("cd : {}, dscp : {}", meta.getCd(), meta.getDscp());
    }
  }

  @Override
  protected void setCodeDscp(List<V> values,
      Map<String, DictionaryMeta> requestMetas) {
    if(CollectionUtils.isEmpty(values)) {
      return;
    }

    for (V v : values) {
      setCodeDscp(v, requestMetas);
    }
  }



}
