package spring_transaction;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  // 让事务生效
@EnableTransactionManagement // 开启事务
public class SpringTransactionConfig {

    // Spring事务是基于AOP来实现的
    // Spring事务的隔离级别直接基于数据库的隔离级别

    // 底层的工作原理:
    // class DemoTransactionProxy extends DemoTransactionClass {
    //     DemoTransactionClass target;
    //
    //     判断是否有@Transactional注解
    //        创建数据库连接connection
    //        connection.autocommit=false 方便回滚
    //     target.test();
    //        事务会统一提交，反之会回滚
    // }
}
