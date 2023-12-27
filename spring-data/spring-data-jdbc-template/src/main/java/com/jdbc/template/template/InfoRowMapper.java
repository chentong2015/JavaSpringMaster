package com.jdbc.template.template;

import com.jdbc.template.model.Information;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

// TODO: ORM层提供的实现, 定义Table Row和Java Object之间的映射
// 自定义实现RowMapper<T>接 Mapping rows of a ResultSet by JdbcTemplate
public class InfoRowMapper implements RowMapper<Information> {

    // 1. resultSet: the sets of rows by query SQL
    // 2. rowNum: the number of rows returned
    @Override
    public Information mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        // 可以拿到查询后结果的MetaData元数据信息，判断query是否正确
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();
        // 拿到指定的columnIndex的数据信息
        Object object = JdbcUtils.getResultSetValue(resultSet, 2);

        return new Information(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("place"),
                resultSet.getInt("year"));
    }
}
