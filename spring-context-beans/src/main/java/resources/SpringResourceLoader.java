package resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;

// Spring框架提供不同的API从项目的classpath路径读取文件
// - ClassPathResource
// - ResourceUtils
// - SerializationUtils (object <-> byte[])序列化工具
public class SpringResourceLoader {

    // classpath路径默认为项目的/resources目录
    public void loadFileStreamFromResources() throws IOException {
        Resource resource = new ClassPathResource("static/app.json");
        FileInputStream inputStream = new FileInputStream(resource.getFile());
    }

    public void loadFileByResourceUtils() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:sample.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    }
}
