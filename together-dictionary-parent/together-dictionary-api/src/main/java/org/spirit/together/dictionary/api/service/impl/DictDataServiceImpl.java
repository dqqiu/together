package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.spirit.together.dictionary.api.model.DictData;
import org.spirit.together.dictionary.api.vo.DictDataVo;
import org.spirit.framework.core.utils.BeanUtils;
import org.spirit.together.dictionary.api.mapper.DictDataMapper;
import org.spirit.together.dictionary.api.service.DictDataService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictDataServiceImpl")
public class DictDataServiceImpl implements DictDataService {
  
  @Autowired
  private DictDataMapper dictDataMapper;
  
  
  public int insert(DictData dictData) {
    return dictDataMapper.insert(dictData);
  }
  
  
  public int insertBySelective(DictData dictData) {
    return dictDataMapper.insertBySelective(dictData);
  }
  
  public DictDataVo getByPrimaryKey(java.lang.String cd,java.lang.String dictDataTypeCd) {
    DictData dictData = dictDataMapper.getByPrimaryKey(cd, dictDataTypeCd);
    if(ObjectUtils.isEmpty(dictData)) {
      return null;
    }
    DictDataVo dictDataVo = new DictDataVo();
    BeanUtils.copy(dictData, dictDataVo);
    return dictDataVo;
  }
  
  public List<DictData> getByCondition(DictData dictData) {
    return dictDataMapper.getByCondition(dictData);
  }
  
  
  public List<DictData> getByCondition(DictDataVo dictDataVo) {
    return dictDataMapper.getByCondition(dictDataVo);
  }
  
  
  public int getCountByCondition(DictData dictData) {
    return dictDataMapper.getCountByCondition(dictData);
  }
  
  
  public int getCountByCondition(DictDataVo dictDataVo) {
    return dictDataMapper.getCountByCondition(dictDataVo);
  }
  
  
  public int updateByPrimaryKey(DictData dictData) {
    return dictDataMapper.updateByPrimaryKey(dictData);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd,java.lang.String dictDataTypeCd) {
    return dictDataMapper.deleteByPrimaryKey(cd, dictDataTypeCd);
  }

  
  public int deleteByCondition(DictData dictData) {
    return dictDataMapper.deleteByCondition(dictData);
  }

  
  public int deleteByCondition(DictDataVo dictDataVo) {
    return dictDataMapper.deleteByCondition(dictDataVo);
  }
}
