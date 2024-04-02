package com.spring.batch.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import java.util.List;

public class AbstractDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public AbstractDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected void batchUpdate(List<?> list, String sql) {
        if (list != null && !list.isEmpty()) {
            SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(list.toArray());
            jdbcTemplate.batchUpdate(sql, params);
        }
    }
}
