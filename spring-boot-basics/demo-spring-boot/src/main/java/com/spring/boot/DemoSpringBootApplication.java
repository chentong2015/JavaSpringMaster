package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO. Spring Boot启动注意
// 1. 启动类型不能放置在空包路径下(Won't be accessible from the default package)
// 2. 默认扫描范围@SpringBootApplication注解注解类型的package下所有的包
//    扫描所有标注@Repository, @Service, @Component, @Controller...的类型
// 3. 可以移除对于特定名称的扫描，或者自定义扫描的包名scanBasePackages
//    @ComponentScan(excludeFilters = {
//      @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
//      @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class}
//    )}
@SpringBootApplication()
// @EntityScan("com.spring.data.jpa.entity")
// @EnableJpaRepositories("com.spring.data.jpa.repositories")
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }
}
