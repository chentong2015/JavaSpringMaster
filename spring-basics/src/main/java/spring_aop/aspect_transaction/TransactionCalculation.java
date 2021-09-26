package spring_aop.aspect_transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionCalculation {

    // TODO: Spring事务的底层实现原理 ?
    // 通过AOP切面编程，实现共享连接(ThreadLocal来存储)

    // Spring支持事务传播的7种设置：方法调用级别的传播
    // REQUIRED(0),
    // SUPPORTS(1),
    // MANDATORY(2),
    // REQUIRES_NEW(3),
    // NOT_SUPPORTED(4),
    // NEVER(5),
    // NESTED(6);
    @Transactional(propagation = Propagation.NEVER)
    public void pay(String accountId, double money) {
        System.out.println("Test ...");
    }
}
