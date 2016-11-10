package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictCity;
import org.spirit.together.dictionary.api.vo.DictCityVo;
import org.spirit.together.dictionary.api.mapper.DictCityMapper;
import org.spirit.together.dictionary.api.service.DictCityService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictCityServiceImpl")
public class DictCityServiceImpl implements DictCityService {
  
  @Autowired
  private DictCityMapper dictCityMapper;
  
  
  public int insert(DictCity dictCity) {
    return dictCityMapper.insert(dictCity);
  }
  
  
  public int insertBySelective(DictCity dictCity) {
    return dictCityMapper.insertBySelective(dictCity);
  }
  
  
  public DictCity getByPrimaryKey(java.lang.String cd) {
    return dictCityMapper.getByPrimaryKey(cd);
  }
  
  
  public List<DictCity> getByCondition(DictCity dictCity) {
    return dictCityMapper.getByCondition(dictCity);
  }
  
  
  public List<DictCity> getByCondition(DictCityVo dictCityVo) {
    return dictCityMapper.getByCondition(dictCityVo);
  }
  
  
  public int getCountByCondition(DictCity dictCity) {
    return dictCityMapper.getCountByCondition(dictCity);
  }
  
  
  public int getCountByCondition(DictCityVo dictCityVo) {
    return dictCityMapper.getCountByCondition(dictCityVo);
  }
  
  
  public int updateByPrimaryKey(DictCity dictCity) {
    return dictCityMapper.updateByPrimaryKey(dictCity);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictCityMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictCity dictCity) {
    return dictCityMapper.deleteByCondition(dictCity);
  }

  
  public int deleteByCondition(DictCityVo dictCityVo) {
    return dictCityMapper.deleteByCondition(dictCityVo);
  }
}
