package org.spirit.together.dictionary.api.external;

import java.util.Arrays;
import java.util.List;

/**
 * @Project       : together-dictionary-api
 * @Program Name  : org.spirit.together.dictionary.api.external.DictionaryHttpPath.java
 * @Description   : qiudequan 数据字典http访问路径枚举
 * @Author        : qiudequan
 * @Creation Date : 2016年12月11日 下午1:13:46 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月11日        create
 */
public enum DictionaryHttpPath implements BaseHttpPathApi{
  DICT_DATA_BY_CODE("/dict_data/dictDataTypeCd/{dict_data_type_cd}/cd/{cd}", Arrays.asList("cd", "dict_data_type_cd"), "根据code和type查询常用词典"),
  
  DICT_STATE_BY_CODE("/dict_state/cd/{cd}", Arrays.asList("cd"), "根据code查询国家");
  
  private String path;
  private List<String> params;
  private String desc;
  
  private DictionaryHttpPath(String path, List<String> params, String desc) {
    this.path = path;
    this.params = params;
    this.desc = desc;
  }
  
  private DictionaryHttpPath(String path, String desc) {
    this(path, null, desc);
  }
  
  public String getPath() {
    return this.path;
  }
  
  public List<String> getParams() {
    return this.params;
  }
  
  public String getDesc() {
    return this.desc;
  }
}
