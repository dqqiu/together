package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictDataType;
import org.spirit.together.dictionary.api.vo.DictDataTypeVo;
import org.spirit.together.dictionary.api.mapper.DictDataTypeMapper;
import org.spirit.together.dictionary.api.service.DictDataTypeService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictDataTypeServiceImpl")
public class DictDataTypeServiceImpl implements DictDataTypeService {
  
  @Autowired
  private DictDataTypeMapper dictDataTypeMapper;
  
  
  public int insert(DictDataType dictDataType) {
    return dictDataTypeMapper.insert(dictDataType);
  }
  
  
  public int insertBySelective(DictDataType dictDataType) {
    return dictDataTypeMapper.insertBySelective(dictDataType);
  }
  
  
  public DictDataType getByPrimaryKey(java.lang.String cd) {
    return dictDataTypeMapper.getByPrimaryKey(cd);
  }
  
  
  public List<DictDataType> getByCondition(DictDataType dictDataType) {
    return dictDataTypeMapper.getByCondition(dictDataType);
  }
  
  
  public List<DictDataType> getByCondition(DictDataTypeVo dictDataTypeVo) {
    return dictDataTypeMapper.getByCondition(dictDataTypeVo);
  }
  
  
  public int getCountByCondition(DictDataType dictDataType) {
    return dictDataTypeMapper.getCountByCondition(dictDataType);
  }
  
  
  public int getCountByCondition(DictDataTypeVo dictDataTypeVo) {
    return dictDataTypeMapper.getCountByCondition(dictDataTypeVo);
  }
  
  
  public int updateByPrimaryKey(DictDataType dictDataType) {
    return dictDataTypeMapper.updateByPrimaryKey(dictDataType);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictDataTypeMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictDataType dictDataType) {
    return dictDataTypeMapper.deleteByCondition(dictDataType);
  }

  
  public int deleteByCondition(DictDataTypeVo dictDataTypeVo) {
    return dictDataTypeMapper.deleteByCondition(dictDataTypeVo);
  }
}
