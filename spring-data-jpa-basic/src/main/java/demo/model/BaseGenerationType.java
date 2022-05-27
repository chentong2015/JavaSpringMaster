package demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 不通过的GenerationType之间的区别
// GenerationType.AUTO      默认配置的自动增加 > SQLite, H2 Database
// GenerationType.IDENTITY  只有部分的数据库提供支持 > MySQL, PSQL
// GenerationType.SEQUENCE
// GenerationType.TABLE
public class BaseGenerationType {

    // https://www.baeldung.com/jpa-strategies-when-set-primary-key

    // UUID并不时候做主键
    @Id
    @GeneratedValue(generator = "system-id")
    @GenericGenerator(name = "system-id", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id = null;

}
