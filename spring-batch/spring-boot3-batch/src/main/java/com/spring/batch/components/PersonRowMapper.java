package com.spring.batch.components;

import com.spring.batch.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// Spring JDBC RowMapper: 定义如何从查询结果Row映射到Class对象
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(rs.getString(1), rs.getString(2));
    }
}
