package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictDistrict;
import org.spirit.together.dictionary.api.vo.DictDistrictVo;
import org.spirit.together.dictionary.api.mapper.DictDistrictMapper;
import org.spirit.together.dictionary.api.service.DictDistrictService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictDistrictServiceImpl")
public class DictDistrictServiceImpl implements DictDistrictService {
  
  @Autowired
  private DictDistrictMapper dictDistrictMapper;
  
  
  public int insert(DictDistrict dictDistrict) {
    return dictDistrictMapper.insert(dictDistrict);
  }
  
  
  public int insertBySelective(DictDistrict dictDistrict) {
    return dictDistrictMapper.insertBySelective(dictDistrict);
  }
  
  
  public DictDistrict getByPrimaryKey(java.lang.String cd) {
    return dictDistrictMapper.getByPrimaryKey(cd);
  }
  
  
  public List<DictDistrict> getByCondition(DictDistrict dictDistrict) {
    return dictDistrictMapper.getByCondition(dictDistrict);
  }
  
  
  public List<DictDistrict> getByCondition(DictDistrictVo dictDistrictVo) {
    return dictDistrictMapper.getByCondition(dictDistrictVo);
  }
  
  
  public int getCountByCondition(DictDistrict dictDistrict) {
    return dictDistrictMapper.getCountByCondition(dictDistrict);
  }
  
  
  public int getCountByCondition(DictDistrictVo dictDistrictVo) {
    return dictDistrictMapper.getCountByCondition(dictDistrictVo);
  }
  
  
  public int updateByPrimaryKey(DictDistrict dictDistrict) {
    return dictDistrictMapper.updateByPrimaryKey(dictDistrict);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictDistrictMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictDistrict dictDistrict) {
    return dictDistrictMapper.deleteByCondition(dictDistrict);
  }

  
  public int deleteByCondition(DictDistrictVo dictDistrictVo) {
    return dictDistrictMapper.deleteByCondition(dictDistrictVo);
  }
}
