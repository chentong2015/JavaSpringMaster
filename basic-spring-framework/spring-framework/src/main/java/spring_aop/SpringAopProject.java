package spring_aop;

import org.springframework.transaction.annotation.Transactional;

// AOP应用场景:
// 1. 日志，性能监控
// 2. 读写分离，多数据源的切换(Router路由)
// 3. 做分布式事务，分库分表
// AOP基本使用:
// https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
public class SpringAopProject {

    // 将Spring AOP中"责任链+递归"的设计应用到实战: 校验规则链
    // 1. 定义校验规则接口 ICheck
    //    抽象公共方法
    // 2. 不同校验的实现(规则类)
    //    校验参数合法性
    //    校验参数互斥性
    //    ....(可扩展性)
    // 3. 针对不同的业务场景"配置"不同规则类
    //    A业务：123 (可修改性)
    //    B业务：124
    //    ....(可扩展性)

    // 场景02: 分布式事务处理
    // 1. 在提交订单时，抛出异常，导致(订单本地)事务回滚
    // 2. 数据库中没有增加订单信息，但是商品的库存却减少了 !!
    @Transactional
    public void pay(String accountId, double money) {
        // 发送请求
        // 如果异常，则会本地回滚
        System.out.println("Test ...");
    }
}
