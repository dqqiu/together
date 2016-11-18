package org.spirit.together.dictionary.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spirit.together.dictionary.api.model.DictData;
import org.spirit.together.dictionary.api.vo.DictDataVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictDataMapper {
  int insert(DictData dictData);
  
  int insertBySelective(DictData dictData);
  
  DictData getByPrimaryKey(@Param("cd") java.lang.String cd,@Param("dictDataTypeCd") java.lang.String dictDataTypeCd);
  
  List<DictData> getByCondition(DictData dictData);
  
  List<DictData> getByCondition(DictDataVo dictDataVo);
  
  int getCountByCondition(DictData dictData);
  
  int getCountByCondition(DictDataVo dictDataVo);
  
  int updateByPrimaryKey(DictData dictData);
  
  int deleteByPrimaryKey(@Param("cd") java.lang.String cd,@Param("dictDataTypeCd") java.lang.String dictDataTypeCd);

  int deleteByCondition(DictData dictData);

  int deleteByCondition(DictDataVo dictDataVo);
}
