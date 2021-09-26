package spring_aop;

import org.springframework.transaction.annotation.Transactional;

// Spring AOP应用场景
// 1. 做分布式事务
// 2. 做分库分表
public class SpringAopProject {

    // 将Spring AOP中"责任链+递归"的设计应用到实战项目中
    // 场景01 : 校验规则链
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
