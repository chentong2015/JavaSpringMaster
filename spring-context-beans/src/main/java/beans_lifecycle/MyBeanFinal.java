package beans_lifecycle;

// 声明bean不可被继承
public final class MyBeanFinal {

    // 改方法在bean配置的时候，自动被回调执行
    public void shutdown() {
        // shutdown something
    }
}
