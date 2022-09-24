package demo.repositories;

import demo.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

// PagingAndSortingRepository 这个Repository不会作为bean被注入到IoC中
public interface UserPagingSortingRepository extends PagingAndSortingRepository<User, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    void deleteUserByEmail(String email);

}
