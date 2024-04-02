package com.spring.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private NamedParameterJdbcTemplate jdbcTemplate;

    protected void batchUpdate(List<?> list, String sql) {
        if (list != null && !list.isEmpty()) {
            SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(list.toArray());
            jdbcTemplate.batchUpdate(sql, params);
        }
    }
}
