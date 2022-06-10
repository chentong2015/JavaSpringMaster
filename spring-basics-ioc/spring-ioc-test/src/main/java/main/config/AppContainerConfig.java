package main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Java Annotation Configuration
 * 1. Annotation Configuration
 * 2. @Configuration  : 作为Spring Container的配置, 同样会被处理成@Component, 因为具有该注解
 * 3. @ComponentScan  : 扫描指定的package下面(包括嵌套的package)标记@Component注解的类型
 * 4. @Bean annotation: 声明bean方法作为bean definition
 */
@Configuration // 替换beans.xml文件中最大的标签<beans>，从而使用纯annotation来配置(注入)
@Import(NumberGeneratorConfig.class) // 从不同的配置文件中加载bean
@ComponentScan(basePackages = "main")
public class AppContainerConfig {

    // The configuration class contains beans definitions 类型中应该声明bean方法(代表bean的定义，对象的创建)

    // @Bean: method produces a bean to be managed by the spring container
    // 1. 使用Bean method而非@Component, 可以在创建对象的时候添加额外的配置for bean !!
    // 2. TODO: 方法的名称默认取指定类型的名称(首字母小写), 两者必须严格匹配
    // 这里bean的configuration完全可以通过给类型添加@Component来注入container ===> 减少代码量 !!
    // @Bean
    // public NumberGenerator numberGenerator() {
    //    return new NumberGeneratorImpl();
    // }
    //
}
