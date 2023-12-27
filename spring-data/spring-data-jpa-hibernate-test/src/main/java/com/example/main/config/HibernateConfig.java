package com.example.main.config;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    
    // @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        // sessionFactory.setServiceRegistryBuilder(serviceRegistryBuilder());
        return sessionFactory;
    }

    // @Bean
    public DataSource dataSource() {
        // define your DataSource bean here
        return null;
    }

    // @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        // define other Hibernate properties here
        return properties;
    }

    // @Bean
    public StandardServiceRegistryBuilder serviceRegistryBuilder() {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySetting("hibernate.temp.use_jdbc_metadata_defaults", false);

        // define other service registry settings here
        // serviceRegistryBuilder.addInitiator(new MyCustomServiceInitiator());
        return serviceRegistryBuilder;
    }

    //private static class MyCustomServiceInitiator implements ServiceInitiator<MyCustomService> {
    //
    //    @Override
    //    public MyCustomService initiateService(Map configurationValues, ServiceRegistryImplementor registry) {
    //        // define your custom service implementation here
    //        return new MyCustomServiceImpl();
    //    }
    //
    //    @Override
    //    public Class<MyCustomService> getServiceInitiated() {
    //        return MyCustomService.class;
    //    }
    //}
}
