package resource_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import resource_injection.res.InjectionResourceFields;
import resource_injection.res.InjectionResourceSetter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ResourceInjectionConfig {

    // TODO. 注入Bean作为一个资源，通过@Resource注解获取(通过fields或setter设置)
    // 注意资源注入的名称，在获取时根据名称一致来获取
    // 注意资源数据的Scope，是否具有全局性
    @Bean(name = "myListResource")
    @Scope(scopeName = "prototype")
    public List<String> myListResource() {
        return new ArrayList<>();
    }

    @Bean(name = "myResourceFields")
    public InjectionResourceFields injectionResourceFields() {
        return new InjectionResourceFields();
    }

    @Bean(name = "myResourceSetter")
    public InjectionResourceSetter injectionResourceSetter() {
        return new InjectionResourceSetter();
    }

}
