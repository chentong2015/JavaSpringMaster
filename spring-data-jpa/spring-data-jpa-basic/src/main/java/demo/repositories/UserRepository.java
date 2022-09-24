package demo.repositories;

import demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// @Transactional注解标明该Repository中的所有方法都将以事务的方式执行
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * This method will find a User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    User findByEmail(String email);
}
