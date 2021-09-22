package spring_mvc;

public class BaseSpringMVC {

    // Spring MVC中父子容器: (Spring整合Spring MVC)
    // TODO: 子容器可以应引用父容器的对象，目的是为了"指责单一"
    // Servlet WebApplicationContext 子容器 => C,View,Handler
    // Root WebApplicationContext    父容器 => IoC容器

    // 源码分析入口: Spring MVC
    public static void main(String[] args) {
    }
}
