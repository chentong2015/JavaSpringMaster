package xml.bean;

// Container中bean的实例化的方法
// 1. 使用构造器和setter
// 2. 使用bean的静态方法来创建 staticMethods()
// 3. 使用实例化工厂Factory: instanceMethod()
public class BeanInstanceCreation {

    private String name;

    public BeanInstanceCreation(String name) {
        this.name = name;
    }

    // 使用bean静态方法来创建对象 <bean ... factory-method="createInstance" >
    public static BeanInstanceCreation createInstance(String name) {
        System.out.println("invoke static factory method");
        return new BeanInstanceCreation(name);
    }

    // 使用Bean Factory的实例方法来创建对象
    // 1. 将factory注入到container中 <bean id="beanFactory" ..>
    // 2. 使用工厂中的实例方法<bean factory-bean="beanFactory" factory-method="getInstance">
    public BeanInstanceCreation getInstance(String name) {
        System.out.println("invoke instance factory method");
        return new BeanInstanceCreation(name);
    }
}
