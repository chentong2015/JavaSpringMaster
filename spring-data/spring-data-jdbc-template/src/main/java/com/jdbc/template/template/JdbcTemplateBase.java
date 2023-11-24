package com.jdbc.template.template;

import com.jdbc.template.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository("baseJdbcTemplate")
public class JdbcTemplateBase implements InformationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 执行操作时，jdbcTemplate会将所有的参数依次替换query中的?
    // Return the number of rows affected
    @Override
    public boolean insertInformation(Information info) {
        String query = "INSERT INTO information (id, name, place, year) VALUES (?, ?, ?, ?)";
        Object[] args = new Object[]{info.getId(), info.getName(), info.getPlace(), info.getYear()};
        return jdbcTemplate.update(query, args) == 1;
    }

    // 查询数据时，需要提供自定义的RowMapper，将查询出来的ResultSet映射成指定类型的对象实例
    @Override
    public Information getInformation(int id) {
        String query = "SELECT * FROM information where id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.queryForObject(query, new InfoRowMapper(), args);
    }

    // 如果查询返回是Standard Java Types, 则不需要使用RowMapper
    public long countInformation() {
        String query = "SELECT count(*) FROM information";
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public void cleanupTable() {
        // 只清空table中所有信息，只写一次日志记录
        String query = "TRUNCATE TABLE information";
        jdbcTemplate.execute(query);
    }
}
