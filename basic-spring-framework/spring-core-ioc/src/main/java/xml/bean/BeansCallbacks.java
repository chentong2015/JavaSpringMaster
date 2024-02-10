package xml.bean;

// Callback 回调方法：
// 1. 能够做为参数传递给被的方法，在某个event事件发生的时候触发invoke 
// 2. 定义bean的回调方法，container会自动在满足条件的时候触发
// 3. 这些回调方法关联着bean's lifecycle
public class BeansCallbacks {

    // Bean Lifecycle 调用的顺序:
    // 1. constructor
    // 2. setter
    // 3. init method
    // 4. destroy method

    private String name;

    public BeansCallbacks() {
        System.out.println("constructor");
    }

    public void setName() {
        name = "new name";
        System.out.println("set property");
    }

    // 该初始化方法能够在所有的属性设置好之后，做进一步的初始化配置 init-method="initialize"
    public void initialize() {
        System.out.println("initialize method called");
    }

    // 由"全局化"的配置来调用指定bean中定义的"标准方法" default-init-method="postConstruct"
    public void postConstruct() {
        System.out.println("postConstruct method called");
    }

    // 该方法可以用于数据的清理，释放 destroy-method="destroy"
    public void destroy() {
        System.out.println("destroy method called");
    }

    public void preDestroy() {
        System.out.println("preDestroy method called");
    }
}
