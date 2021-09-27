package spring_mybatis;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"spring_mybatis"})
@EnableTransactionManagement
@MapperScan(basePackages = {"spring_mybatis"})
public class MyBatisConfig {

    // @MapperScan注解的作用和@Bean(mapperScannerConfigurer)功能一致 ?
    //

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("mybatis/*.xml"));
        return factoryBean;
    }

    @Bean
    public DataSource dataSource() {

        MyDataSource dataSource = new MyDataSource();
        // set data source info
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSource dataSource = dataSource();
        // PlatformTransactionManager transactionManager = new PlatformTransactionManager(dataSource());
        return null;
    }
}
