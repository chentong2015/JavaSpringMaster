package com.event.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // TODO. Scheduled注解仅支持Java 17以上版本进行编译 ?
    // 将被周期性调用的方法
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        String dateStr = dateFormat.format(new Date());
        log.info("The time is now {}", dateStr);
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    // 只有第一次使用初始设置的延迟
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void scheduleFixedRateWithInitialDelayTask() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println("Fixed rate task with one second initial delay - " + now);
    }

    // Support Cron Expressions
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {
        long now = System.currentTimeMillis() / 1000;
        System.out.println("schedule tasks using cron jobs - " + now);
    }
}
