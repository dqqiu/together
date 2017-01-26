package org.spirit.framework.boot.security.stateless;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * @Project       : framework-boot-security
 * @Program Name  : org.spirit.framework.boot.security.stateless.StatelessSubjectFactory.java
 * @Description   : qiudequan 无会话状态的SubjectFactory
 * @Author        : qiudequan
 * @Creation Date : 2016年12月3日 下午9:45:43 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年12月3日        create
 */
public class StatelessSubjectFactory extends DefaultWebSubjectFactory {

  @Override
  public Subject createSubject(SubjectContext context) {
    // 不创建session会话
    context.setSessionCreationEnabled(false);
    return super.createSubject(context);
  }

}
