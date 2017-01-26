package org.spirit.together.dictionary.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.dictionary.api.model.DictState;
import org.spirit.together.dictionary.api.vo.DictStateVo;
import org.spirit.framework.core.utils.BeanUtils;
import org.spirit.together.dictionary.api.mapper.DictStateMapper;
import org.spirit.together.dictionary.api.service.DictStateService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "dictStateServiceImpl")
public class DictStateServiceImpl implements DictStateService {
  
  @Autowired
  private DictStateMapper dictStateMapper;
  
  
  public int insert(DictState dictState) {
    return dictStateMapper.insert(dictState);
  }
  
  
  public int insertBySelective(DictState dictState) {
    return dictStateMapper.insertBySelective(dictState);
  }
  
  
  public DictStateVo getByPrimaryKey(java.lang.String cd) {
    DictState state = dictStateMapper.getByPrimaryKey(cd);
    DictStateVo dictStateVo = new DictStateVo();
    BeanUtils.copy(state, dictStateVo);
    return dictStateVo;
  }
  
  
  public List<DictState> getByCondition(DictState dictState) {
    return dictStateMapper.getByCondition(dictState);
  }
  
  
  public List<DictState> getByCondition(DictStateVo dictStateVo) {
    return dictStateMapper.getByCondition(dictStateVo);
  }
  
  
  public int getCountByCondition(DictState dictState) {
    return dictStateMapper.getCountByCondition(dictState);
  }
  
  
  public int getCountByCondition(DictStateVo dictStateVo) {
    return dictStateMapper.getCountByCondition(dictStateVo);
  }
  
  
  public int updateByPrimaryKey(DictState dictState) {
    return dictStateMapper.updateByPrimaryKey(dictState);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String cd) {
    return dictStateMapper.deleteByPrimaryKey(cd);
  }

  
  public int deleteByCondition(DictState dictState) {
    return dictStateMapper.deleteByCondition(dictState);
  }

  
  public int deleteByCondition(DictStateVo dictStateVo) {
    return dictStateMapper.deleteByCondition(dictStateVo);
  }
}
