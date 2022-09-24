package demo.transaction;

import demo.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

// PagingAndSortingRepository 不会作为bean被注入到IoC中
public interface UserPagingSortingRepository extends PagingAndSortingRepository<User, Long> {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Modifying(clearAutomatically = true)
    void deleteUserByEmail(String email);

    // TODO. 定义事务在抛出什么异常时进行回滚
    // rollback a transaction for the listed checked exceptions
    @Transactional(rollbackFor = SQLException.class)
    void testTransactionRollback(String name);

    // prevent rollback of the transaction for the listed exception
    @Transactional(noRollbackFor = SQLException.class)
    void testTransactionNoRollback(String email);
}
