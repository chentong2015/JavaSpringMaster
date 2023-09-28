package com.spring.batch.components;

import com.spring.batch.model.Person;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("!!! JOB FINISHED! Time to verify the results");

            String query = "SELECT first_name, last_name FROM people";
            jdbcTemplate.query(query, new PersonRowMapper()).forEach(
                    person -> System.out.println("Found person in the database."));
        }
    }

    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Person(rs.getString(1), rs.getString(2));
        }
    }
}
