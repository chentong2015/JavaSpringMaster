package demo.repositories;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

// use the @MockBean to add mock objects to the Spring application context. 
// The mock will replace any existing bean of the same type in the application context
// If no bean of the same type is defined, a new one will be added.
@RunWith(SpringRunner.class)
public class SpringMockBeanDemoTest {

    // Mock掉IoC中指定的Bean，模拟其中方法执行过程中的行为
    @MockBean
    SessionRepository mockSessionRepository;

    @Autowired
    ApplicationContext context;

    @Test
    public void testMockRepository() {
        Mockito.when(mockSessionRepository.count()).thenReturn(10L);

        SessionRepository newSessionRepository = context.getBean(SessionRepository.class);
        long count = newSessionRepository.count();

        // 确定获取到的是新的返回数据
        Assertions.assertEquals(10L, count);
        // 确定指定的方法被调用了
        Mockito.verify(mockSessionRepository).count();
    }
}
