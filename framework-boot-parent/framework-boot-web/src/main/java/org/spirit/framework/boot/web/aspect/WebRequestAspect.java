package org.spirit.framework.boot.web.aspect;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.aspect.WebRequestAspect.java
 * @Description   : qiudequan Web请求切面，以日志方式记录访问时间等信息
 * @Author        : qiudequan
 * @Creation Date : 2016年10月16日 下午7:22:51 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月16日        create
 */
@Aspect
@Component
public class WebRequestAspect {
  private static final Logger logger = LoggerFactory.getLogger(WebRequestAspect.class);
  
  ThreadLocal<Long> startTime = new ThreadLocal<Long>();
  
  /**
   *  @Description	: qiudequan 切入点
   *  @return         : void
   *  @Creation Date  : 2016年10月16日 下午7:22:24 
   *  @Author         : qiudequan
   */
  @Pointcut(value = "execution(public * org.spirit..*.controller..*.*(..))")
  public void webRequest() {
    
  }
  
  @Before("webRequest()")
  public void doBefore(JoinPoint joinPoint) {
    logger.info(">>>>>>>>>>>> Starting Request <<<<<<<<<<<<");
    startTime.set(System.currentTimeMillis());
    
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    
    // 记录请求内容
    logger.info("Request URL : {}", request.getRequestURL().toString());
    logger.info("Http Method : {}", request.getMethod());
    logger.info("IP : {}", request.getRemoteAddr());
    Signature signature = joinPoint.getSignature();
    logger.info("Class Method : {}.{}", signature.getDeclaringTypeName(), signature.getName());
    logger.info("Args : {}", Arrays.toString(joinPoint.getArgs()));
    
  //获取所有参数：
    Enumeration<String> enu=request.getParameterNames(); 
    while(enu.hasMoreElements()){ 
        String paraName=(String) enu.nextElement(); 
        logger.info("{} : {}", paraName, request.getParameter(paraName)); 
    } 
  }
  
  @After("webRequest()")
  public void doAfter(JoinPoint joinPoint) {
    long diff = System.currentTimeMillis() - startTime.get();
    logger.info(">>>>>>>>>>>> Request Completed <<<<<<<<<<<<");
    logger.info("This request is completed, it takes {} ms", diff);
  }
}
