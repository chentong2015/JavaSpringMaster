package context_property;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class SpringResourceLoader {

    // 从classpath /resources目录下加载文件
    public void loadFileStreamFromResources() throws IOException {
        Resource resource = new ClassPathResource("app.json");
        FileInputStream inputStream = new FileInputStream(resource.getFile());
        byte[] content = IOUtils.toByteArray(inputStream);
        System.out.println(content);
    }

    // 使用Spring的资源工具类从classpath中加载文件
    public void loadFileByResourceUtils() throws FileNotFoundException {
        String resourcePath = "sample.txt";
        File file = ResourceUtils.getFile("classpath:" + resourcePath);

        FileReader fileReader = new FileReader(resourcePath);
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
    }
}
