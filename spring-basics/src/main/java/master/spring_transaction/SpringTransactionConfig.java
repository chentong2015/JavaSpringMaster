package master.spring_transaction;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  // 让事务生效
@EnableTransactionManagement // 开启事务
public class SpringTransactionConfig {

    // Spring事务
    // 1. 隔离级别直接基于数据库的隔离级别
    // 2. 基于AOP来实现的
    //    底层的工作原理: 对事务的执行进行控制
    //    class DemoTransactionProxy extends DemoTransactionClass {
    //        DemoTransactionClass target;
    //        判断是否有@Transactional注解
    //           创建数据库连接connection
    //           connection.autocommit=false 方便回滚
    //        target.test();
    //           事务会统一提交，反之会回滚
    //    }
}
