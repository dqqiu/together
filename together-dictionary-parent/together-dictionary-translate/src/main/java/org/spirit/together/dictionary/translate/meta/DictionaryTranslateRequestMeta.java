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
public class DictionaryTranslateRequestMeta implements DictionaryMeta {

  public DictionaryTranslateRequestMeta() {}
  
  public DictionaryTranslateRequestMeta(String cd, Object cdValue) {
    this.cd = cd;
    this.cdValue = cdValue;
    this.cdDscpName = this.cd + "Dscp";
  }
  
  /** 被翻译字段code */
  protected String cd;
  
  /** 被翻译字段的值 */
  protected Object cdValue;
  
  /** 被翻译字段对应的释义字段名 */
  protected String cdDscpName;
  
  /** 被翻译字段翻译后的释义 */
  protected Object dscp;
  
  /** 字典唯一值 */
  protected String key;
  
  public String getCd() {
    return cd;
  }
  public void setCd(String cd) {
    this.cd = cd;
  }
  public Object getCdValue() {
    return cdValue;
  }
  public void setCdValue(Object cdValue) {
    this.cdValue = cdValue;
  }
  public String getCdDscpName() {
    return cdDscpName;
  }
  public void setCdDscpName(String cdDscpName) {
    this.cdDscpName = this.cd + "Dscp";
  }
  public Object getDscp() {
    return dscp;
  }
  public void setDscp(Object dscp) {
    this.dscp = dscp;
  }
  public String getKey() {
    return this.cd + this.cdValue;
  }
  public void setKey(String key) {
    this.key = key;
  }
}
