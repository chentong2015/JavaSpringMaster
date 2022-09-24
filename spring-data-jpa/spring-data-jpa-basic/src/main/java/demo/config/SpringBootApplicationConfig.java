package demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
// @EnableTransactionManagement
public class SpringBootApplicationConfig {

    // TODO: 从配置文件中自动加载配置的信息，完成DataSource的设置
    // ?allowPublicKeyRetrieval=true?useSSL=false
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

    // 使用DataSourceBuilder构建DataSource
    // @Bean
    // public DataSource dataSource2() {
    //     DataSourceBuilder builder = DataSourceBuilder.create();
    //     builder.url("jdbc:mysql://localhost:3306/dbspringboot");
    //     return builder.build();
    // }

    // TODO. 如果项目支持的DataSource不唯一，可以使用@Qualifier注解来区别注入的同类型bean
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

