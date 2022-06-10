package demo.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 同一个Service可以针对不同的Datasource进行操作
// 使用@Qualifier名称来区别使用
@Service
public class SessionService {

    private DataSource datasource1;
    private DataSource datasource2;

    public SessionService(@Qualifier("mysql-datasource") DataSource datasource1,
                          @Qualifier("psql-datasource") DataSource datasource2) {
        this.datasource1 = datasource1;
        this.datasource2 = datasource2;
    }

    //  操作不同的Datasource数据库资源
    public void testDatasource1() throws SQLException {
        Connection connection = datasource1.getConnection();
    }

    public void testDatasource2() throws SQLException {
        Connection connection = datasource2.getConnection();
    }
}
