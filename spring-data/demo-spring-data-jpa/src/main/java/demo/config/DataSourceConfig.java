package demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    // TODO: 从配置文件中自动加载配置的信息，完成DataSource的设置 ?allowPublicKeyRetrieval=true?useSSL=false
    //  如果这里的DataSource连接出错，则会在Spring Boot启动时抛出异常 Connection: Refused
    @Bean
    @Qualifier("mysql-datasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbspringboot");
        return dataSource;
    }

    // TODO. 使用@Qualifier注解来区别注入的同类型bean, 支持不同DataSource
    @Bean
    @Qualifier("mysql-db2")
    public DataSource dataSource2() {
        // 使用DataSourceBuilder构建DataSource
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/dbspringboot");
        return builder.build();
    }

    @Bean
    @Qualifier("psql-datasource")
    public DataSource getAnotherDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgresql");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/my_database");
        return dataSource;
    }
}

