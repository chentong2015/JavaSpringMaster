package com.example.aop.aspect;

import com.example.aop.entity.Race;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectRaceService {

    @Pointcut("execution(* com.example.aop.service.RaceService.saveRace(..))")
    private void pointCutRace() {
    }

    @After(value = "pointCutRace()")
    public void publishRaceMessage(JoinPoint joinPoint) {
        Race race = (Race) joinPoint.getArgs()[0];
        publishMessage(race.getName());
    }

    // Publish message to MQ bus
    private void publishMessage(String name) {
        String message = "New '" + name + "' has been created and stored in DB";
        System.out.println(message);
    }
}
