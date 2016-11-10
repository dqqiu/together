package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictProvince;
import org.spirit.together.dictionary.api.vo.DictProvinceVo;
import org.spirit.together.dictionary.api.mapper.DictProvinceMapper;
import org.spirit.together.dictionary.api.service.DictProvinceService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictProvinceServiceImpl")
public class DictProvinceServiceImpl implements DictProvinceService {
  
  @Autowired
  private DictProvinceMapper dictProvinceMapper;
  
  
  public int insert(DictProvince dictProvince) {
    return dictProvinceMapper.insert(dictProvince);
  }
  
  
  public int insertBySelective(DictProvince dictProvince) {
    return dictProvinceMapper.insertBySelective(dictProvince);
  }
  
  
  public DictProvince getByPrimaryKey(java.lang.String cd) {
    return dictProvinceMapper.getByPrimaryKey(cd);
  }
  
  
  public List<DictProvince> getByCondition(DictProvince dictProvince) {
    return dictProvinceMapper.getByCondition(dictProvince);
  }
  
  
  public List<DictProvince> getByCondition(DictProvinceVo dictProvinceVo) {
    return dictProvinceMapper.getByCondition(dictProvinceVo);
  }
  
  
  public int getCountByCondition(DictProvince dictProvince) {
    return dictProvinceMapper.getCountByCondition(dictProvince);
  }
  
  
  public int getCountByCondition(DictProvinceVo dictProvinceVo) {
    return dictProvinceMapper.getCountByCondition(dictProvinceVo);
  }
  
  
  public int updateByPrimaryKey(DictProvince dictProvince) {
    return dictProvinceMapper.updateByPrimaryKey(dictProvince);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictProvinceMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictProvince dictProvince) {
    return dictProvinceMapper.deleteByCondition(dictProvince);
  }

  
  public int deleteByCondition(DictProvinceVo dictProvinceVo) {
    return dictProvinceMapper.deleteByCondition(dictProvinceVo);
  }
}
