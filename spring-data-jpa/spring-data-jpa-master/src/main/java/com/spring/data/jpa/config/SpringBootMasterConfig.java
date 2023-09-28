package com.spring.data.jpa.config;

import com.spring.data.jpa.service.MyConfigurationService;
import com.spring.data.jpa.service.MyConfigurationServiceImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class SpringBootMasterConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hibernate_demo");
        return dataSource;
    }

    // TODO. ShallowEtagHeaderFilter能在返回的Response Headers中添加Etag属性
    //  它能buffer whole response, 并且将计算Content的长度放到Response Headers中
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        filterBean.setFilter(new ShallowEtagHeaderFilter());
        filterBean.setUrlPatterns(Arrays.asList("*"));
        return filterBean;
    }

    // 在@Configuration配置文件中注入Bean，特定接口的实现类
    @Bean("MY_CONFIG_SERVICE")
    public MyConfigurationService myConfigurationService() {
        return new MyConfigurationServiceImpl();
    }
}
