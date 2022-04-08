package master.bean.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// Spring会将该类型视为一个bean
@Component
public class BaseService {

    // Field injection is not recommended !
    @Autowired
    private OrderService orderService;

    // 这里的属性在从容器中获取bean的时候需要有值 ==> 在设置值的过程中需要有逻辑
    // @Autowired不能直接使用该注解 ==> 通过"初始化前"来完成设置
    private User defaultUser;

    @PostConstruct
    public void getDefaultUser() {
        // mysql --> user object --> defaultUser
    }

    // Spring默认使用无参的构造方法 ==> 推荐使用构造器注入
    // public UserService() { }

    // 在没有默认构造方法的情况下，Spring无法判断使用那个含参数的构造器
    // TODO: 如果只有一个，则直接使用唯一的一个构造器
    //       如果有多个，则可以添加一个@Autowired，不能添加多个
    private OrderService orderService1;

    // 构造器注入(如果只有唯一一个构造器)
    // Spring从容器中取指定的bean对象来传递参数，不能将参数名称视为beanName去容器中找
    // TODO: 如果根据类型去找，可能会找到多个，只是bean的名称不同  --> byType
    //       再根据参数名称来找，视为bean的名称                 --> byName
    public BaseService(OrderService orderService) {
        this.orderService1 = orderService;
        System.out.println("Construct 1");
    }

    // 构造器注入(如果只有唯一一个构造器)
    // Spring必须全部找到bean，才能成功执行
    public BaseService(OrderService orderService, OrderService orderService1) {
        this.orderService1 = orderService;
        System.out.println("Construct 2");
    }
}
