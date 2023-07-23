package com.dataaccess.main.config;

import com.dataaccess.main.bean.MyEntity;
import com.dataaccess.main.context.LegacySpringApplicationContext;
import com.dataaccess.main.das.MyBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.lang.reflect.Method;

@Configuration
// @ConfigurationProperties
@EnableConfigurationProperties
@PropertySource("classpath:database.properties")
public class DataAccessConfig {

    // Check here if we are in a spring data context or in a murex context
    @Bean
    public MyEntity createMyEntity(LegacySpringApplicationContext applicationContext) throws Exception {
        Class<?> springDataClass = Class.forName("com.dataaccess.main.context.LegacySpringApplicationContext");
        Method getBeanByClassMethod = springDataClass.getMethod("getBeanByClass", Class.class);
        MyBean myBean = (MyBean) getBeanByClassMethod.invoke(null, MyBean.class);
        System.out.println(myBean);
        return new MyEntity();
    }
}
