package main.bean;

import com.spring.annotation.Component;

@Component(value = "iComponentImpl")
public class ProxyComponentImpl implements ProxyComponent {

    @Override
    public void test() {
        System.out.println("test");
    }
}
