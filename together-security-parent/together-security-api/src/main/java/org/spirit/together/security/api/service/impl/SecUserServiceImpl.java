package org.spirit.together.security.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.spirit.together.security.api.model.SecUser;
import org.spirit.together.security.api.vo.SecUserVo;
import org.spirit.together.security.api.mapper.SecUserMapper;
import org.spirit.together.security.api.service.SecUserService;

/**
 * 
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@Service(value = "secUserServiceImpl")
public class SecUserServiceImpl implements SecUserService {
  
  @Autowired
  private SecUserMapper secUserMapper;
  
  
  public int insert(SecUser secUser) {
    return secUserMapper.insert(secUser);
  }
  
  
  public int insertBySelective(SecUser secUser) {
    return secUserMapper.insertBySelective(secUser);
  }
  
  
  public SecUser getByPrimaryKey(java.lang.String id) {
    return secUserMapper.getByPrimaryKey(id);
  }
  
  
  public List<SecUser> getByCondition(SecUser secUser) {
    return secUserMapper.getByCondition(secUser);
  }
  
  
  public List<SecUser> getByCondition(SecUserVo secUserVo) {
    return secUserMapper.getByCondition(secUserVo);
  }
  
  
  public int getCountByCondition(SecUser secUser) {
    return secUserMapper.getCountByCondition(secUser);
  }
  
  
  public int getCountByCondition(SecUserVo secUserVo) {
    return secUserMapper.getCountByCondition(secUserVo);
  }
  
  
  public int updateByPrimaryKey(SecUser secUser) {
    return secUserMapper.updateByPrimaryKey(secUser);
  }
  
  
  public int deleteByPrimaryKey(java.lang.String id) {
    return secUserMapper.deleteByPrimaryKey(id);
  }

  
  public int deleteByCondition(SecUser secUser) {
    return secUserMapper.deleteByCondition(secUser);
  }

  
  public int deleteByCondition(SecUserVo secUserVo) {
    return secUserMapper.deleteByCondition(secUserVo);
  }
}
