package com.example.main;

import com.example.main.storage.StorageProperties;
import com.example.main.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadingFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadingFilesApplication.class, args);
    }

    // 在tomcat启动完成之后，自动运行指定逻辑
    @Bean
    CommandLineRunner init(StorageService storageService) {
        // 实现的run(String... args)方法，带有指定的参数
        return (args) -> {
            // 初始化Server端的Storage
            storageService.deleteAll();
            storageService.init();
        };
    }
}
