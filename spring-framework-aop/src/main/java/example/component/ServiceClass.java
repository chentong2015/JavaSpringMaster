package example.component;

import org.springframework.stereotype.Component;

@Component
public class ServiceClass {

    public void printSomething(String value1) {
        System.out.println(value1);
        System.out.println("print something");
    }
}
