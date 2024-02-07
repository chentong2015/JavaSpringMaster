package org.example.caching;

import org.example.caching.bean.Employee;
import org.example.caching.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CachingApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(CachingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Employee employee = new Employee(1L, "John", "Doe", "email@domain.com");
        service.saveEmployee(employee);

        // 第一遍后期会从底层DB查找数据，第二遍获取会直接从缓存中返回
        System.out.println(service.getEmployeeById(1L));
        System.out.println(service.getEmployeeById(1L));

        employee.setFirstName("chen");
        service.updateEmployee(employee);
        System.out.println(service.getEmployeeById(1L));
        System.out.println(service.getEmployeeById(1L));
    }
}