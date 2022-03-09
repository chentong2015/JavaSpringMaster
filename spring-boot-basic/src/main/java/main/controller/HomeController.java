package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.Cacheable;

@Controller
public class HomeController {
    
    @ResponseBody
    @GetMapping("/home")
    @Cacheable(value = "homeCache")
    public String home() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Home page";
    }
}
