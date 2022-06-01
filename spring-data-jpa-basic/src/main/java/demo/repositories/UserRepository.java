package demo.repositories;

import demo.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

// 标注执行Query时的事务性
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * This method will find a User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    User findByEmail(String email);
}
