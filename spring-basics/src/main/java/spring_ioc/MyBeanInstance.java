package spring_ioc;

public final class MyBeanInstance {

    // 改方法在bean配置的时候，自动被回调执行
    public void shutdown() {
        // shutdown something
    }
}
