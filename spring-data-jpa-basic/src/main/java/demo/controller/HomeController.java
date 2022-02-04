package demo.controller;

import demo.model.User;
import demo.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    // TODO: 注意这里使用的链接
    //       不推荐使用URL来传递重要的参数信息
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
}
