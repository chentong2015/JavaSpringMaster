package scheduling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchedulerTaskTest {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(SchedulerTaskConfig.class);
        appContext.refresh();

        System.out.println("Application Started.");
        Thread.sleep(100000);
    }
}