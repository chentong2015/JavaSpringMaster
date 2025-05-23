package resource;

import org.springframework.core.io.*;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

// TODO. Spring提供两种资源加载路径: Filesystem, Classpath
public class ResourceLoaderCore {

    public static void main(String[] args) throws IOException {
        // TODO. 从Classpath获取Resource资源数据
        Resource resource1 = new DefaultResourceLoader().getResource("static/sample.txt");

        Resource resource2 = new ClassPathResource("static/app.json");
        FileInputStream file2 = new FileInputStream(resource2.getFile());
        System.out.println(resource2.getContentAsString(Charset.defaultCharset()));
        System.out.println(resource2.getURL());


        // TODO. 从classpath(/resources)目录加载FileInputStream
        File file = ResourceUtils.getFile("classpath:static/sample.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println(reader.lines().collect(Collectors.joining()));


        // TODO. 从Filesystem文件系统路径加载Resource资源
        Resource fileSystemResource = new FileSystemResource("root/full/path/text.xml");
    }
}
