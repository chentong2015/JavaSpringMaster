package com.jdbc.template.template;

import com.jdbc.template.model.Information;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

// 使用Spring JdbcTemplate来实现数据的批量操作
public class JdbcTemplateBatch implements InformationDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int[] batchUpdate(final List<Information> infoList) {
        return this.jdbcTemplate.batchUpdate(
                "INSERT INTO information (id, name, place, year) VALUES (?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Information information = infoList.get(i);
                        ps.setInt(1, information.getId());
                        ps.setString(2, information.getName());
                        ps.setString(3, information.getPlace());
                        ps.setInt(4, information.getYear());
                    }

                    public int getBatchSize() {
                        return infoList.size();
                    }
                });
    }

    @Override
    public boolean insertInformation(Information info) {
        return false;
    }

    @Override
    public Information getInformation(int id) {
        return null;
    }

    @Override
    public void cleanupTable() {
    }
}
