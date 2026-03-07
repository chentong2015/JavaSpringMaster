package scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SchedulerBean {

    // TODO. 使用异步线程周期性地完成后端task任务
    @Scheduled(fixedDelay = 100, timeUnit = TimeUnit.MILLISECONDS)
    private void onScheduled() {
        try {
            System.out.println("Run scheduled task");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}