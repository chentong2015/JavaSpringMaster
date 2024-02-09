package main.bean;

import com.spring.annotation.Component;

@Component(value = "iComponentImpl")
public class IComponentImpl implements IComponent {

    @Override
    public void test() {
        System.out.println("test");
    }
}
