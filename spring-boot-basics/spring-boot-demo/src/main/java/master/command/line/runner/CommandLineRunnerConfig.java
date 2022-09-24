package master.command.line.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerConfig implements CommandLineRunner {

    // 设置Spring Boot的program arguments启动参数
    // 实际输出效果 args[0]: first_value
    @Override
    public void run(String... args) throws Exception {
        // Use args here
        System.out.printf("args[0]: " + args[0]);
    }
}
