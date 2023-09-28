package com.spring.boot.controller;

import com.spring.boot.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.Cacheable;


@Slf4j
@Controller
public class BaseController {

    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @ResponseBody
    @GetMapping("/cache")
    @Cacheable(value = "homeCache")
    public String home() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Home page";
    }

    @GetMapping("home")
    public String home(Model model) {
        log.info("home method called ...");
        model.addAttribute("value", "About page");
        model.addAttribute("resultMessage", "This is the result message");
        return "home";
    }

    // @RequestParam 注解参数设置
    // 1. @RequestParam("message") String message 默认message的值为null
    // 2. @RequestParam(name="message",required=false)
    // 3. @RequestParam(name="message",defaultValue="default value")
    // 4. @RequestParam(name = "message") Optional<String> message
    @PostMapping(value = "play")
    public String play(@RequestParam int input) {
        System.out.println("Process the input for playing ...");
        return "redirect:/home";
    }

    @GetMapping("game")
    public String about(Model model) {
        model.addAttribute("game", baseService.getGameMessage());
        return "game";
    }
}
