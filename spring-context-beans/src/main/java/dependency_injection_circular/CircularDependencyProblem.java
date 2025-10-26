package dependency_injection_circular;

// Spring并没有解决所有的循环依赖问题
// 当通过构造注入时产生的相互依赖，由于没有办法实例化，没有办法生成原始对象，二三级缓存无效
public class CircularDependencyProblem {

    // @Component
    // public class AService {
    //    private BService bService;
    //    唯一的构造器, 使用构造器注入, byType, byName
    //    public AService(BService bService) {
    //      this.bService = bService;
    //    }
    // }

    // @Component
    // @Lazy
    // public class BService {
    //    @Lazy
    //    private AService aService;
    //    TODO: @Lazy 添加注解之后可以解决问题
    //          延迟，生成AService的"代理对象(绕过AService类型的代理对象)"传递给构造器 !!
    //    public BService(AService aService) {
    //      this.aService = aService;
    //    }
    //    public void test() {
    //      aService.test(); 调用代理对象的方法，进入到代理逻辑，找真正的AService对象
    //    }
    // }
}
