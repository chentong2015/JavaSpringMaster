package spring_ioc.bean;

// 声明bean不可被继承
public final class MyBeanInstance {

    // 改方法在bean配置的时候，自动被回调执行
    public void shutdown() {
        // shutdown something
    }
}
