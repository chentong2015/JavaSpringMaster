package demo.controller;

import demo.model.User;
import demo.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class HomeController {

    // 使用自定义的配置，然后注入
    @Value("${app.version}")
    private String appVersion;

    // Jackson会将返回的对象自动转成Json
    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map<String, String> map = new HashMap<>();
        map.put("app-version", appVersion);
        return map;
    }

    @Autowired
    private HomeRepository homeRepository;

    // TODO: 注意这里使用的链接, 不推荐使用URL来传递重要的参数信息(可以加密之后传输)
    // http://localhost:8080/user/create?email=[email]&name=[name]
    @ResponseBody
    @RequestMapping("/user/create")
    public String create(String email, String name) {
        String userId = "";
        try {
            User user = new User(email, name);
            homeRepository.save(user);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "Error" + ex.toString();
        }
        return "Create user with id = " + userId;
    }

    // TODO: 使用@RequestParam来获取URL中的参数
    @GetMapping("/api/foos1")
    @ResponseBody
    public String getParam1(@RequestParam Optional<String> id) {
        return "ID: " + id.orElseGet(() -> "not provided");
    }

    @GetMapping("/api/foos2")
    @ResponseBody
    public String getParam2(@RequestParam(defaultValue = "test") String id) {
        return "ID: " + id;
    }

    @PostMapping("/api/foos3")
    @ResponseBody
    public String updateParam3(@RequestParam Map<String, String> allParams) {
        return "Parameters are " + allParams.entrySet();
    }

    // http://localhost:8080/spring-mvc-basics/api/foos?id=1,2,3
    // http://localhost:8080/spring-mvc-basics/api/foos?id=1&id=2
    @GetMapping("/api/foos4")
    @ResponseBody
    public String getParam4(@RequestParam List<String> id) {
        return "IDs are " + id;
    }
}
