package org.spirit.together.dictionary.api.service;

import java.util.List;
import org.spirit.together.dictionary.api.model.DictData;
import org.spirit.together.dictionary.api.vo.DictDataVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictDataService {
  int insert(DictData dictData);
  
  int insertBySelective(DictData dictData);
  
  DictData getByPrimaryKey(java.lang.String cd,java.lang.String dictDataTypeCd);
  
  List<DictData> getByCondition(DictData dictData);
  
  List<DictData> getByCondition(DictDataVo dictDataVo);
  
  int getCountByCondition(DictData dictData);
  
  int getCountByCondition(DictDataVo dictDataVo);
  
  int updateByPrimaryKey(DictData dictData);
  
  int deleteByPrimaryKey(java.lang.String cd,java.lang.String dictDataTypeCd);

  int deleteByCondition(DictData dictData);

  int deleteByCondition(DictDataVo dictDataVo);
}
