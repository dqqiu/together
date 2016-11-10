package org.spirit.together.dictionary.api.mapper;

import java.util.List;
import org.spirit.together.dictionary.api.model.DictCity;
import org.spirit.together.dictionary.api.vo.DictCityVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictCityMapper {
  int insert(DictCity dictCity);
  
  int insertBySelective(DictCity dictCity);
  
  DictCity getByPrimaryKey(java.lang.String cd);
  
  List<DictCity> getByCondition(DictCity dictCity);
  
  List<DictCity> getByCondition(DictCityVo dictCityVo);
  
  int getCountByCondition(DictCity dictCity);
  
  int getCountByCondition(DictCityVo dictCityVo);
  
  int updateByPrimaryKey(DictCity dictCity);
  
  int deleteByPrimaryKey(java.lang.String cd);

  int deleteByCondition(DictCity dictCity);

  int deleteByCondition(DictCityVo dictCityVo);
}
