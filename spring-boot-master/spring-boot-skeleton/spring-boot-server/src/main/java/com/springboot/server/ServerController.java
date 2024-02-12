package com.springboot.server;

import com.springboot.api.DemoClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    private DemoClass demoClass;

    public ServerController(DemoClass demoClass) {
        System.out.println("inject demo class");
        this.demoClass = demoClass;
    }

    @GetMapping("/v1/server/home")
    public String home() {
        return this.demoClass.getName();
    }
}
