import org.springframework.core.io.*;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.Charset;

// TODO. Spring Core提供两种资源加载路径: Filesystem, Classpath
public class SpringResourceLoader {

    public static void main(String[] args) throws IOException {
        // TODO. 直接通过资源加载器加载classpath文件数据
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        String resources = resourceLoader.getResource("static/sample.txt")
                .getContentAsString(Charset.defaultCharset());
        System.out.println(resources);


        // 默认从项目根目录相对路径加载
        Resource fileSystemResource = new FileSystemResource("root/full/path/text.xml");

        // 默认从/resources目录加载
        Resource classPathResource = new ClassPathResource("static/app.json");

        // 从classpath (/resources)目录加载
        File file = ResourceUtils.getFile("classpath:static/sample.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.lines());
    }
}
