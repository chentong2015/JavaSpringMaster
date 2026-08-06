package bean;

public class MyBean {

    public void init() {
        System.out.println("Init something after creating object");
    }

    public void print(String beanName) {
        System.out.println(beanName + ": print something");
    }

    public void stop() {
        System.out.println("Stop and finish lifecycle of object");
    }
}
