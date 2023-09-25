package com.spring.jdbc;

import com.spring.jdbc.config.SpringJdbcConfig;
import com.spring.jdbc.model.Information;
import com.spring.jdbc.template.InformationDao;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

public class DemoSpringJDBC {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        InformationDao informationDao = (InformationDao) context.getBean("baseJdbcTemplate");

        // TODO: JdbcTemplate并不会抛出任何checked异常(JDBC SQL Exceptions), 通常需要自定义检测
        try {
            Information information = informationDao.getInformation(1);
            System.out.println(information);
        } catch (BadSqlGrammarException e) {
            e.printStackTrace();
        } catch (DataAccessException exception) {
            exception.printStackTrace();
        }
        context.close();
    }
}
