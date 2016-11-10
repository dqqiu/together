package org.spirit.framework.boot.web.configuration;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spirit.framework.core.utils.PropertyUtils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.configuration.MyBatisMapperScannerConfig.java
 * @Description   : qiudequan Mybatis扫描配置类
 * @Author        : qiudequan
 * @Creation Date : 2016年11月9日 下午3:52:49 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年11月9日        create
 */
@Configuration
@AutoConfigureAfter(MybatisConfiguration.class)
public class MyBatisMapperScannerConfiguration {
  private static final Logger logger = LoggerFactory.getLogger(MyBatisMapperScannerConfiguration.class);
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
      logger.info(">>>>>>>>>>>> configurate mapperScanner <<<<<<<<<<<<");
      MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
      mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
      String basePackage = PropertyUtils.getProperty("together.mybatis.mapper-scan-packages");
      logger.info(">>>>>>>>>>>> together.mybatis.mapper-scan-packages ： " + basePackage + " <<<<<<<<<<<<");
      mapperScannerConfigurer.setBasePackage(basePackage);
      return mapperScannerConfigurer;
  }
}
