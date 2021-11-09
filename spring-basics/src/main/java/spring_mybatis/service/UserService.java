package spring_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_mybatis.dao.UserMapper;

@Service
public class UserService {

    // Spring整合Mybatis的关键
    // TODO: 如何拿到Mybatis中的代理对象，完成依赖注入
    @Autowired
    private UserMapper userMapper;

    public void testService() {
        userMapper.selectById(1);
    }
}
