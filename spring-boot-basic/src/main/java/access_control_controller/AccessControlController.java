package access_control_controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// Access Control Allow Origin
// https://spring.io/guides/gs/rest-service-cors/
// Java服务端必须提供跨域认证的支持，否则JavaScript(Ajax)无法向其发送请求，获取数据
@RestController
public class AccessControlController {

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/status/test")
    public String test() {
        //  return "<div>test</div>";
        return "{\"order_id\": \"test order id\"}";
    }

    private static final String template = "Hello, %s!";

    // 多线程场景下的原子增加，保证数据累加和统计是准确的  
    private final AtomicLong counter = new AtomicLong();

    // 允许指定的URL发送跨域认证的请求
    // 来自Javascript Ajax发送的请求
    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
