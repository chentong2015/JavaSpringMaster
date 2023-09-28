package demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionCalculation {

    // TODO: 解决方案，注入自己在容器中的代理对象，完成调用
    @Autowired
    private TransactionCalculation calculation;

    @Transactional
    public void testException() {
        // jdbcTemplate.execute("insert ...");
        // 下面抛出异常，事务会自动回滚，执行的SQL语句不会成功
        throw new NullPointerException();
    }
    
    @Transactional
    public void runOuterMethod() {
        // jdbcTemplate.execute("insert ...");
        runInnerMethod();
        calculation.runInnerMethod();
    }

    // TODO: 在调用方法的时候，如果是原始对象在调用，则事务传播的设置不会生效 !!
    @Transactional(propagation = Propagation.NEVER)
    public void runInnerMethod() {
        System.out.println("test inner method");
    }
}
