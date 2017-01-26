package org.spirit.together.security.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spirit.together.security.api.model.SecUser;
import org.spirit.together.security.api.vo.SecUserVo;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
public interface SecUserMapper {
  int insert(SecUser secUser);
  
  int insertBySelective(SecUser secUser);
  
  SecUser getByPrimaryKey(@Param("id") java.lang.String id);
  
  List<SecUser> getByCondition(SecUser secUser);
  
  List<SecUser> getByCondition(SecUserVo secUserVo);
  
  int getCountByCondition(SecUser secUser);
  
  int getCountByCondition(SecUserVo secUserVo);
  
  int updateByPrimaryKey(SecUser secUser);
  
  int deleteByPrimaryKey(@Param("id") java.lang.String id);

  int deleteByCondition(SecUser secUser);

  int deleteByCondition(SecUserVo secUserVo);
}
