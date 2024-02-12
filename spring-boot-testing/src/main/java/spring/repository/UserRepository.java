package spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String getUserNameById(long id) {
        return "user name";
    }

}
