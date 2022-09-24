package demo.repositories;

import demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// @Transactional注解标明该Repository中的所有方法都将以事务的方式执行
@Repository
@Transactional
public interface UserCrudRepository extends CrudRepository<User, Long> {

    /**
     * This method will find a User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    User findByEmail(String email);

    // 提供参数实现模糊查询
    @Modifying
    @Query(value = "update t_users u set u.name = :name where u.email like :e1%", nativeQuery = true)
    void updateUserNameByEmail(@Param("name") String newName, @Param("e1") String email);
    
    @Query(value = "select * from t_users t where upper(t.name) = :name and t.email = :email order by t.id", nativeQuery = true)
    Page<User> findAllByNameAndEmail(@Param("name") String name, @Param("email") String email, Pageable pageable);
}
