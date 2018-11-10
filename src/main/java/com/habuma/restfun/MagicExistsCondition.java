package com.habuma.restfun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {
  /*
  ConditionContext接口内容：
  借助getRegistry()返回的BeanDefinitionRegistry检查bean定义；
借助getBeanFactory()返回的ConfigurableListableBeanFactory检查bean
是否存在，甚至探查bean的属性；
借助getEnvironment()返回的Environment检查环境变量是否存在
以及它的值是什么；
读取并探查getResourceLoader()返回的ResourceLoader所加载的资源；
借助getClassLoader()返回的ClassLoader加载并检查类是否存在
   */
  /*
  AnnotatedTypeMetadata则能够让我们检查带有@Bean注解
  的方法上还有什么其他的注解
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    Environment env = context.getEnvironment();
    //测试用
    System.setProperty("magic","value-test");
    return env.containsProperty("magic");
  }
  /*
  附：关于@Profile注解，
  ProfileCondition通过AnnotatedTypeMetadata得到了用于
  @Profile注解的所有属性。借助该信息，它会明确地检查value属性，
  该属性包含了bean的profile名称。然后，它根据通过
  ConditionContext得到的Environment来检查［借助
  acceptsProfiles()方法］该profile是否处于激活状态。
   */
  
}
