package org.spirit.framework.boot.web.configuration;

import org.spirit.framework.boot.web.properties.AppProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
 * @Description   : qiudequan Swagger2配置，用户生成接口API文档
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
@EnableConfigurationProperties(value = {AppProperties.class})
public class Swagger2Configuration {

  @Bean
  public Docket webApi(AppProperties appProperties){
      Docket docket = new Docket(DocumentationType.SWAGGER_2)
              .groupName(appProperties.getName())
              .genericModelSubstitutes(DeferredResult.class)
              .pathMapping("/")
              .select()
              .paths(PathSelectors.any())
              .build().apiInfo(webApiInfo(appProperties));
      return docket;
  }

  @SuppressWarnings("deprecation")
  private ApiInfo webApiInfo(AppProperties appProperties) {
      ApiInfo apiInfo = new ApiInfo(appProperties.getName() + "接口文档",       // 大标题
          appProperties.getName(),           // 小标题
              "1.0",                                  // 版本
              "",            //
              "dqqiu",                                // 作者
              "",                // 链接显示文字
              "");     // 网站链接
      return apiInfo;
  }
}
