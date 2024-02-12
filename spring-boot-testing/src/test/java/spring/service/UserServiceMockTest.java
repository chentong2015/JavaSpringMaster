package spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import spring.repository.UserRepository;

@SpringBootTest
public class UserServiceMockTest {

    // 自动注入Spring容器中Bean对象
    @Autowired
    private UserService userService;

    // Mock掉UserService中自动注入的bean对象, 使用Mock的对象注入UserService
    // 自定义mock对象的方法调用的行为和逻辑
    @MockBean
    private UserRepository userRepository;

    // 定义当调用mock userDao的getUserNameById(1)方法时返回特定的数据
    @Test
    public void getUserById() throws Exception {
        Mockito.when(userRepository.getUserNameById(1L)).thenReturn("Test");
        String username = userService.getUserId(1L);
        Assertions.assertEquals("Test", username);
    }
}
