package main.service;

import com.spring.annotation.Autowired;
import com.spring.interfacz.BeanNameAware;
import com.spring.annotation.Component;
import com.spring.interfacz.InitializingBean;

@Component("userService")
public class UserService implements BeanNameAware, InitializingBean {

    // Spring需要自动地为属性注入对应的值
    @Autowired
    private OrderService orderService;

    // 依赖注入，自动赋值当前bean的名称
    private String beanName;

    // Spring会自动调用当前方法，并传入当前bean名称
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("Call setBeanName");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 自定义实现的逻辑，可以做数据的验证
        System.out.println("Initializing bean");
    }

    public void testBeanPostProcessor() {
        System.out.println("Call testBeanPostProcessor()");
    }

    public void test() {
        System.out.println(orderService);
    }
}
