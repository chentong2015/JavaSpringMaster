package spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import spring.SpringBootTestingApplication;

@WebAppConfiguration
@SpringBootTest(classes = SpringBootTestingApplication.class)
public class ControllerServiceAsyncTest {

    // @Autowired
    // private BaseService baseService;

    // @Autowired
    // private ThreadPoolTaskExecutor executor;

    @Test
    void process_order_async() throws InterruptedException {
        // 1. 如何等待Thread Pool线程池中的线程结束
        // boolean result = executor.getThreadPoolExecutor().awaitTermination(35, TimeUnit.SECONDS);
        // Assertions.assertTrue(result);

        // 2. 创建新的线程来执行，会导致异步方法瞬间返回
        // Thread thread = new Thread(() -> {
        //     try {
        //         orderService.processMethodAsync(params);
        //     } catch (ApplicationProcessException | InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // });
        // thread.start();
        // thread.join();

        // 3. 从Spring boot IoC ApplicationContext中获取指定的线程池
        //    在指定的时间内等待线程池中的线程运行结束
        // ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor)
        //    ApplicationContextProvider.getBean("threadPoolTaskExecutor");
        // if (!executor.getThreadPoolExecutor().awaitTermination(60, TimeUnit.SECONDS)) {
        //    executor.getThreadPoolExecutor().shutdown();
        // }

        // Assertions.assertEquals();
    }
}
