package org.spirit.together.dictionary.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spirit.together.dictionary.api.model.DictDataType;
import org.spirit.together.dictionary.api.vo.DictDataTypeVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictDataTypeMapper {
  int insert(DictDataType dictDataType);
  
  int insertBySelective(DictDataType dictDataType);
  
  DictDataType getByPrimaryKey(@Param("cd") java.lang.String cd);
  
  List<DictDataType> getByCondition(DictDataType dictDataType);
  
  List<DictDataType> getByCondition(DictDataTypeVo dictDataTypeVo);
  
  int getCountByCondition(DictDataType dictDataType);
  
  int getCountByCondition(DictDataTypeVo dictDataTypeVo);
  
  int updateByPrimaryKey(DictDataType dictDataType);
  
  int deleteByPrimaryKey(@Param("cd") java.lang.String cd);

  int deleteByCondition(DictDataType dictDataType);

  int deleteByCondition(DictDataTypeVo dictDataTypeVo);
}
