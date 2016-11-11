package org.spirit.together.dictionary.translate.meta;

/**
 * @Project       : together-dictionary-translate
 * @Program Name  : org.spirit.together.dictionary.translate.meta.DictionaryTranslateRequestMeta.java
 * @Description   : qiudequan 翻译请求元数据
 * @Author        : qiudequan
 * @Creation Date : 2016年11月11日 上午10:40:55 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月11日        create
 */
public class DictionaryTranslateRequestMeta {
  private String code;
  /** 存储翻译来源值，即翻译前的值 */
  private Object sourceValue;
  /** 存储需要翻译的字段的释义字段名称,即翻译后的值的存储地 */
  private String cdDscpName;
  /** 翻译后的值 */
  private Object cdDscp;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public Object getSourceValue() {
    return sourceValue;
  }
  public void setSourceValue(Object sourceValue) {
    this.sourceValue = sourceValue;
  }
  public String getCdDscpName() {
    return cdDscpName;
  }
  public void setCdDscpName(String cdDscpName) {
    this.cdDscpName = cdDscpName;
  }
  public Object getCdDscp() {
    return cdDscp;
  }
  public void setCdDscp(Object cdDscp) {
    this.cdDscp = cdDscp;
  }
  
}
