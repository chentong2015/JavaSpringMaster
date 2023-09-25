package com.spring.jdbc.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

// TODO: Spring使用路由来切换多个数据源
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    // 从Thread Local中拿到设置好的target data source信息(数据库的下标)
    @Override
    protected Object determineCurrentLookupKey() {
        return MultiDataSourceHolder.getDataSource();
    }

    // @Bean
    public void dataSource() {
        // 使用map来承载所有的数据源，方便做切换
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("dataSource01", "dataSource01()");
        targetDataSource.put("dataSource02", "dataSource02()");
        targetDataSource.put("dataSource03", "dataSource03()");

        // 映射关系的mapping<求模之后的index，keyDataSource>
        Map<Integer, String> setMapping = new HashMap<>();
        setMapping.put(0, "dataSource01");
        setMapping.put(1, "dataSource02");
        setMapping.put(2, "dataSource03");
    }
}
