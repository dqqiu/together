package org.spirit.together.security.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.spirit.together.security.api.service.SecUserService;

/**
 * @created by mapper-generate-1.0
 * @opensource https://www.github.com/dqqiu/mapper-generate
 */
@RestController
@RequestMapping(value = "/sec_user")
public class SecUserController extends WebMvcConfigurerAdapter {
  @Autowired
  private SecUserService secUserService;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    configurer.setUseSuffixPatternMatch(false);
  }
  
  
  
  

}