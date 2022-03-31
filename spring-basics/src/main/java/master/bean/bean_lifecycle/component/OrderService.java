package master.bean.bean_lifecycle.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements InitializingBean {

    // 等效于添加@PostConstruct注解
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Post Construct");

    }
}
