package spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import spring.config.ExcludedTestingConfiguration;
import spring.service.HomeService;

// TODO. 关于SpringBootTest测试的配置
//  @SpringBootTest会自动找到主启动类用于启动Spring application context
// 1. 配置要启动的Spring Boot Main类
// 2. 配置应用启动的随机端口，避免多个测试post冲突
// 3. 设置特殊的测试properties
// 4. 配置测试时要移除的Configuration
// 5. 在测试时注入用于测试的bean
// 6. 加载特殊的配置文件用于测试
// 7. 激活针对于测试的Profile
@SpringBootTest(classes = SpringBootTestingApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
            "spring.security.user.name=test",
            "spring.security.user.password=test123"
    })
@EnableAutoConfiguration(exclude = ExcludedTestingConfiguration.class)
@ContextConfiguration(locations = {"classpath:spring.bean.MyTestBean"})
@TestPropertySource(locations = "classpath:application-it.properties")
@ActiveProfiles("test")
public class SpringBootMainTest {

    // 测试Main的启动并从SpringContext中获取注入的bean
    @Test
    public void testSpringBootApplicationMain() {
        SpringBootTestingApplication.main(new String[]{});
        HomeService homeService = ApplicationContextProvider.getBean(HomeService.class);
        homeService.printHome();
    }
}
