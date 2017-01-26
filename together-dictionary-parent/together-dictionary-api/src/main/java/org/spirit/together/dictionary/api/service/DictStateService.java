package org.spirit.together.dictionary.api.service;

import java.util.List;

import org.spirit.together.dictionary.api.model.DictState;
import org.spirit.together.dictionary.api.vo.DictStateVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictStateService {
  int insert(DictState dictState);
  
  int insertBySelective(DictState dictState);
  
  DictStateVo getByPrimaryKey(java.lang.String cd);
  
  List<DictState> getByCondition(DictState dictState);
  
  List<DictState> getByCondition(DictStateVo dictStateVo);
  
  int getCountByCondition(DictState dictState);
  
  int getCountByCondition(DictStateVo dictStateVo);
  
  int updateByPrimaryKey(DictState dictState);
  
  int deleteByPrimaryKey(java.lang.String cd);

  int deleteByCondition(DictState dictState);

  int deleteByCondition(DictStateVo dictStateVo);
}
