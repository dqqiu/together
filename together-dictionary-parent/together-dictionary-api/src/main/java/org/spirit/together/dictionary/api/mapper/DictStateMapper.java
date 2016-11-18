package org.spirit.together.dictionary.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spirit.together.dictionary.api.model.DictState;
import org.spirit.together.dictionary.api.vo.DictStateVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictStateMapper {
  int insert(DictState dictState);
  
  int insertBySelective(DictState dictState);
  
  DictState getByPrimaryKey(@Param("cd") java.lang.String cd);
  
  List<DictState> getByCondition(DictState dictState);
  
  List<DictState> getByCondition(DictStateVo dictStateVo);
  
  int getCountByCondition(DictState dictState);
  
  int getCountByCondition(DictStateVo dictStateVo);
  
  int updateByPrimaryKey(DictState dictState);
  
  int deleteByPrimaryKey(@Param("cd") java.lang.String cd);

  int deleteByCondition(DictState dictState);

  int deleteByCondition(DictStateVo dictStateVo);
}
