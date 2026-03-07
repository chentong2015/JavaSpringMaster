package scheduling;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("scheduling")
@EnableScheduling // 开启扫描@Scheduled注解
public class SchedulerTaskConfig {

}
