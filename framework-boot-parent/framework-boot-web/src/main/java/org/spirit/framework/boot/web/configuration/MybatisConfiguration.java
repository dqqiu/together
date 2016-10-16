package org.spirit.framework.boot.web.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;

/**
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.configuration.MybatisConfiguration.java
 * @Description   : TODO qiudequan Mybatis配置,开启事务支持
 * @Author        : qiudequan
 * @Creation Date : 2016年10月16日 下午10:24:21 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月16日        create
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfiguration implements TransactionManagementConfigurer {
  private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

  @Autowired
  private DataSource dataSource;

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory(@Value(value = "${mybatis.mapperLocations}") String mapperLocations) {
    logger.info(">>>>>>>>>>>> Declaracting sqlSessionFactory <<<<<<<<<<<<");
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    //添加XML目录
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {
      sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
      logger.info(">>>>>>>>>>>> Mybatis's MapperLocations is [{}] <<<<<<<<<<<<", mapperLocations);
      return sqlSessionFactoryBean.getObject();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } finally {
      logger.info(">>>>>>>>>>>> Declaracted sqlSessionFactory <<<<<<<<<<<<");
    }
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  /**
   *  @Description	: TODO qiudequan 注入PageHelper分页插件
   *  @return         : PageHelper
   *  @Creation Date  : 2016年10月16日 下午10:24:38 
   *  @Author         : qiudequan
   */
  @Bean
  public PageHelper pageHelper() {
    logger.info(">>>>>>>>>>>> Injecting PageHelper Plugin <<<<<<<<<<<<");
    PageHelper pageHelper = new PageHelper();
    Properties prop = new Properties();
    prop.setProperty("offsetAsPageNum", "true");
    prop.setProperty("rowBoundsWithCount", "true");
    prop.setProperty("reasonable", "true");
    pageHelper.setProperties(prop);
    logger.info(">>>>>>>>>>>> Injected PageHelper Plugin <<<<<<<<<<<<");
    return pageHelper;
  }

  @Bean
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return new DataSourceTransactionManager(dataSource);
  }
}
