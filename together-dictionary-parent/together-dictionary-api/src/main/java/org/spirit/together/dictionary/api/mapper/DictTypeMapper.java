package org.spirit.together.dictionary.api.mapper;

import java.util.List;
import org.spirit.together.dictionary.api.model.DictType;
import org.spirit.together.dictionary.api.vo.DictTypeVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictTypeMapper {
  int insert(DictType dictType);
  
  int insertBySelective(DictType dictType);
  
  DictType getByPrimaryKey(java.lang.String cd);
  
  List<DictType> getByCondition(DictType dictType);
  
  List<DictType> getByCondition(DictTypeVo dictTypeVo);
  
  int getCountByCondition(DictType dictType);
  
  int getCountByCondition(DictTypeVo dictTypeVo);
  
  int updateByPrimaryKey(DictType dictType);
  
  int deleteByPrimaryKey(java.lang.String cd);

  int deleteByCondition(DictType dictType);

  int deleteByCondition(DictTypeVo dictTypeVo);
}
