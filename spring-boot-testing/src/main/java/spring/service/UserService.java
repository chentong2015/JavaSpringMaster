package spring.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserId(long id) {
        return "new user";
    }
}
