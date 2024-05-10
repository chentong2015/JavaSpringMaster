package resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;

// - ResourceUtils 资源工具类型
// - SerializationUtils (object <-> byte[])序列化工具
public class SpringResourceUtils {

    // TODO. Spring Core提供两种资源加载路径
    public void loadResources() {
        // 默认从项目根目录相对路径加载
        Resource fileSystemResource = new FileSystemResource("root/full/path/text.xml");

        // 默认从/resources目录加载
        Resource classPathResource = new ClassPathResource("static/app.json");
    }

    public void testResourceUtils() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:sample.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    }
}
