package org.spirit.together.dictionary.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spirit.together.dictionary.api.model.DictDistrict;
import org.spirit.together.dictionary.api.vo.DictDistrictVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictDistrictMapper {
  int insert(DictDistrict dictDistrict);
  
  int insertBySelective(DictDistrict dictDistrict);
  
  DictDistrict getByPrimaryKey(@Param("cd") java.lang.String cd);
  
  List<DictDistrict> getByCondition(DictDistrict dictDistrict);
  
  List<DictDistrict> getByCondition(DictDistrictVo dictDistrictVo);
  
  int getCountByCondition(DictDistrict dictDistrict);
  
  int getCountByCondition(DictDistrictVo dictDistrictVo);
  
  int updateByPrimaryKey(DictDistrict dictDistrict);
  
  int deleteByPrimaryKey(@Param("cd") java.lang.String cd);

  int deleteByCondition(DictDistrict dictDistrict);

  int deleteByCondition(DictDistrictVo dictDistrictVo);
}
