package main.bean;

import com.spring.annotation.Component;
import com.spring.annotation.PostConstruct;

// TODO. 如果只有一个构造器，则直接使用唯一的一个，构造器无需添加@Autowired
//  当存在多个含参构造器时，Spring无法判断使用那个含参数的构造器
// 1. 可以添加一个@Autowired到其中一个构造器，不能添加多个
// 2. Spring从容器中取指定的bean对象来传递参数
//    - byType 根据类型可能会找到多个，只是bean的名称不同
//    - byName 再根据参数名称来找，视为bean的名称(参数名称不能视为bean名称)
// 3. Spring必须全部找到bean参数才能成功执行
@Component
public class BeanPostConstruct {

    private BeanDemo beanDemo;

    // Spring默认使用无参的构造方法，推荐使用构造器注入
    public BeanPostConstruct() { }

    public BeanPostConstruct(BeanDemo beanDemo) {
        this.beanDemo = beanDemo;
        System.out.println("Construct 1");
    }

    public BeanPostConstruct(BeanDemo beanDemo1,  BeanDemo beanDemo2) {
        this.beanDemo = beanDemo1;
        System.out.println("Construct 2");
    }

    // 该标记的方法会在bean被实例化之后调用
    @PostConstruct
    public void testPostConstruct() {
        System.out.println("call post construct function");
    }

    // TODO. @PreDestroy
    // PreDestroy annotation is used on signal that instance is in the process of being removed by container
    public void preDestroy() {
        System.out.println("Pre destroy generator object");
    }
}
