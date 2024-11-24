package resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class ResourceLocationDemo {

    // Resource源资源来自于Classpath路径
    @Value("file.csv")
    private Resource resource1;

    // Resource资源来自于File项目路径下
    @Value("file:spring-context-beans/src/main/resources/output.xml")
    private Resource resource2;

    @Autowired
    private ResourceLoader resourceLoader;

    // TODO. 通过不同的定位方式获取到资源数据
    public void testResourceLocations() throws IOException {
        System.out.println(this.resource1.getContentAsString(Charset.defaultCharset()));

        System.out.println(this.resource2.getContentAsString(Charset.defaultCharset()));

        Resource resource3  = this.resourceLoader.getResource("classpath:file.txt");
        System.out.println(resource3.getContentAsString(Charset.defaultCharset()));
    }
}
