package org.spirit.together.dictionary.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.spirit"})
@EnableAutoConfiguration
public class TogetherDictionaryRestApplication {
  public static void main(String[] args) {
    SpringApplication.run(TogetherDictionaryRestApplication.class, args);            
  }
}   
