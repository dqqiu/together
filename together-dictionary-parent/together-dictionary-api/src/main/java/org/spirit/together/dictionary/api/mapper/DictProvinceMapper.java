package org.spirit.together.dictionary.api.mapper;

import java.util.List;
import org.spirit.together.dictionary.api.model.DictProvince;
import org.spirit.together.dictionary.api.vo.DictProvinceVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface DictProvinceMapper {
  int insert(DictProvince dictProvince);
  
  int insertBySelective(DictProvince dictProvince);
  
  DictProvince getByPrimaryKey(java.lang.String cd);
  
  List<DictProvince> getByCondition(DictProvince dictProvince);
  
  List<DictProvince> getByCondition(DictProvinceVo dictProvinceVo);
  
  int getCountByCondition(DictProvince dictProvince);
  
  int getCountByCondition(DictProvinceVo dictProvinceVo);
  
  int updateByPrimaryKey(DictProvince dictProvince);
  
  int deleteByPrimaryKey(java.lang.String cd);

  int deleteByCondition(DictProvince dictProvince);

  int deleteByCondition(DictProvinceVo dictProvinceVo);
}
