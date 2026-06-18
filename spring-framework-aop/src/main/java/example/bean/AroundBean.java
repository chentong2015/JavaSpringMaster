package example.bean;

import org.springframework.stereotype.Component;

@Component
public class AroundBean {

    public void hello() {
        System.out.println("in hello");
    }
}
