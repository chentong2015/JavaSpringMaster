package bean.bean_lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanPostConstruct implements InitializingBean {

    // 等效于添加@PostConstruct注解
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Post Construct");
    }
}
