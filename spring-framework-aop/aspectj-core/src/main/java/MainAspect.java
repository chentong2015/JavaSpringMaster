import aspect.AspectAroundDemo;

public class MainAspect {

    public static void main(String[] args) {
        // SecuredClass service = new SecuredClass();
        // service.unlockedMethod();
        // service.lockedMethod();

        // @Around定义被拦截的方法所执行的前后文:
        // in around before execution(void xxx.hello())
        //   before execution(void xxx.hello())
        //     in hello
        //   after execution(void xxx.hello())
        // in around after execution(void xxx.hello())
        // in around before execution(void xxx.hello())
        // in around after execution(void xxx.hello())
        new AspectAroundDemo().hello();
        AspectAroundDemo.runAround = false;
        new AspectAroundDemo().hello();
    }
}
