package com.habuma.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MagicConfig {

  @Bean
  @Conditional(MagicExistsCondition.class)
  /*
   条件化的bean
   */
  public MagicBean magicBean() {
    return new MagicBean();
  }
  
}