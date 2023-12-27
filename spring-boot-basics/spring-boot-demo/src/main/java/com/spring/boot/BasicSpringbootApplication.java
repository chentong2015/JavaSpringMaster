package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// 默认扫描的范围是@SpringBootApplication注解注解类型的package下所有的包
// 扫描所有标注了@Repository, @Service, @Component, @Controller...的类型
// @ComponentScan(excludeFilters = {
//    @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
//    @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})}
//
// @EntityScan("com.spring.data.jpa.entity")
// @EnableJpaRepositories("com.spring.data.jpa.repositories")

@SpringBootApplication
public class BasicSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringbootApplication.class, args);
    }
}
