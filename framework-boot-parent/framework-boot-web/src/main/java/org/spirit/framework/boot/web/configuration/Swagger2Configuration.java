package org.spirit.framework.boot.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.configuration.Swagger2Configuration.java
 * @Description   : TODO qiudequan Swagger2配置，用户生成接口API文档
 * @Author        : qiudequan
 * @Creation Date : 2016年10月14日 下午10:25:04 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月14日        create
 */

@Configuration
@EnableSwagger2                         // 启用Swager2
@ComponentScan(basePackages = {"org.spirit"})
public class Swagger2Configuration {

  @SuppressWarnings("unchecked")
  @Bean
  public Docket webApi(){
      Docket docket = new Docket(DocumentationType.SWAGGER_2)
              .groupName("WebApi")
              .genericModelSubstitutes(DeferredResult.class)
              .pathMapping("/")
              .select()
              .paths(Predicates.or(PathSelectors.regex("/api/*")))
              .build().apiInfo(webApiInfo());
      return docket;
  }

  @SuppressWarnings("deprecation")
  private ApiInfo webApiInfo() {
      ApiInfo apiInfo = new ApiInfo("WebApi接口",       // 大标题
              "WebApi相关测试",           // 小标题
              "1.0",                                  // 版本
              "",            //
              "dqqiu",                                // 作者
              "",                // 链接显示文字
              "");     // 网站链接
      return apiInfo;
  }
}
