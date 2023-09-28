package demo.controller;

import demo.entity.User;
import demo.transaction.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class HomeController {

    // 使用自定义的配置，然后注入
    @Value("${app.version}")
    private String appVersion;

    private UserCrudRepository userRepository;

    @Autowired
    public HomeController(UserCrudRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 注意这里使用的链接, 不推荐使用URL来传递重要的参数信息(可以加密之后传输)
    // http://localhost:8080/user/create?email=[email]&name=[name]
    @ResponseBody
    @RequestMapping("/user/create")
    public String create(String email, String name) {
        String userId = "";
        try {
            User user = new User(email, name);
            userRepository.save(user);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "Error" + ex.toString();
        }
        return "Create user with id = " + userId;
    }

    // TODO: @RequestParam获取URL中的参数
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

    // TODO: @RequestHeader获取请求的header中的信息
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestHeader("accept-language") String language) {
        // code that uses the language variable
        // 返回请求的实体，其中配置response信息和详细的状态
        return new ResponseEntity<>("greeting", HttpStatus.OK);
    }

    @GetMapping("/double")
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber) {
        String result = String.format("%d * 2 = %d", myNumber, (myNumber * 2));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Get our headers as an HttpHeaders object
    @GetMapping("/getBaseUrl")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
        InetSocketAddress host = headers.getHost();
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        return new ResponseEntity<String>(String.format("Base URL = %s", url), HttpStatus.OK);
    }
}
