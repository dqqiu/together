package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictType;
import org.spirit.together.dictionary.api.vo.DictTypeVo;
import org.spirit.together.dictionary.api.mapper.DictTypeMapper;
import org.spirit.together.dictionary.api.service.DictTypeService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictTypeServiceImpl")
public class DictTypeServiceImpl implements DictTypeService {
  
  @Autowired
  private DictTypeMapper dictTypeMapper;
  
  
  public int insert(DictType dictType) {
    return dictTypeMapper.insert(dictType);
  }
  
  
  public int insertBySelective(DictType dictType) {
    return dictTypeMapper.insertBySelective(dictType);
  }
  
  
  public DictType getByPrimaryKey(java.lang.String cd) {
    return dictTypeMapper.getByPrimaryKey(cd);
  }
  
  
  public List<DictType> getByCondition(DictType dictType) {
    return dictTypeMapper.getByCondition(dictType);
  }
  
  
  public List<DictType> getByCondition(DictTypeVo dictTypeVo) {
    return dictTypeMapper.getByCondition(dictTypeVo);
  }
  
  
  public int getCountByCondition(DictType dictType) {
    return dictTypeMapper.getCountByCondition(dictType);
  }
  
  
  public int getCountByCondition(DictTypeVo dictTypeVo) {
    return dictTypeMapper.getCountByCondition(dictTypeVo);
  }
  
  
  public int updateByPrimaryKey(DictType dictType) {
    return dictTypeMapper.updateByPrimaryKey(dictType);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictTypeMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictType dictType) {
    return dictTypeMapper.deleteByCondition(dictType);
  }

  
  public int deleteByCondition(DictTypeVo dictTypeVo) {
    return dictTypeMapper.deleteByCondition(dictTypeVo);
  }
}
