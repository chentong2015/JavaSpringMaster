package com.spring.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @ConfigurationProperties 设置从指定的属性配置文件中加载并映射
// map or bind the .properties or yml configuration values to Java objects.
@Component
@ConfigurationProperties(prefix = "dbcp.datasource")
public class JdbcProperties {

    private String username;
    private String password;
    private String url;
    private String driverClassName;

    public JdbcProperties() {
    }

    public JdbcProperties(String username, String password, String url, String driverClassName) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
