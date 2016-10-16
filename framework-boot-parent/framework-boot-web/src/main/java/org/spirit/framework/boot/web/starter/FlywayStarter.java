package org.spirit.framework.boot.web.starter;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 实现CommandLineRunner的类，会在SpringBoot启动时运行，
 * 多个实现了CommandLineRunner的类的执行顺序可以通过@order进行指定
 * -@order的值小的先执行，可以为负数
 * @Project       : framework-boot-web
 * @Program Name  : org.spirit.framework.boot.web.starter.FlywayStarter.java
 * @Description   : TODO qiudequan Flyway启动类
 * @Author        : qiudequan
 * @Creation Date : 2016年10月16日 上午12:04:08 
 * @ModificationHistory  
 * Who          When             What 
 * ----------   -------------    -----------------------------------
 * qiudequan     2016年10月16日        create
 */
@Component
@Order(value = -1)
public class FlywayStarter implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(FlywayStarter.class); 
  
  @Autowired
  private DataSource dataSource;
  
  public void run(String... args) throws Exception {
    logger.info(">>>>>>>>>> Flyway is moving data migration <<<<<<<<<<");
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    flyway.setEncoding("UTF-8");
    try {
      flyway.migrate();
    } catch (Exception e) {
      flyway.repair();
      e.printStackTrace();
    }
    logger.info(">>>>>>>>>> Flyway is moved data migration <<<<<<<<<<");
  }

}

