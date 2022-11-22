package context;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

public class SpringResourceLoader {

    // 从classpath /resources目录下加载文件
    public void loadFileStreamFromResources() throws IOException {
        Resource resource = new ClassPathResource("app.json");
        FileInputStream inputStream = new FileInputStream(resource.getFile());
        byte[] content = IOUtils.toByteArray(inputStream);
        System.out.println(content);
    }
}
