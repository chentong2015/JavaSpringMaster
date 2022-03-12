package com.ctong.springboot.controller;

import com.ctong.springboot.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// TODO: @RequestParam可以支持几种可选参数的设置
// 1. @RequestParam("message") String message ==> 如果没有提供，这里的message将会是null
// 2. @RequestParam(name="message",required=false)
// 3. @RequestParam(name="message",defaultValue="default value")
// 4. @RequestParam(name = "message") Optional<String> message
@Slf4j
@Controller
public class BaseController {

    private BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    // localhost:8080/home 不在需要提供项目名称, Spring将会自动的configure settings, 是URL的路径变短
    @GetMapping("home")
    public String home(Model model) {
        log.info("home method called ...");
        model.addAttribute("value", "About page");
        model.addAttribute("resultMessage", "This is the result message");
        return "home";
    }

    @PostMapping("play")
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
