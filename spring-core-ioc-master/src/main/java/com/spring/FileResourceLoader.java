package com.spring;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileResourceLoader {

    public static List<File> getClassFiles(String folder) {
        // 拿到加载当前项目类型的ClassLoader，也即Application ClassLoader
        ClassLoader classLoader = FileResourceLoader.class.getClassLoader();

        // 拿到自定路径的目录，遍历指定Folder路径下的所有文件
        URL resource = classLoader.getResource(folder);
        try {
            Path folderPath = Paths.get(resource.toURI());
            return Files.walk(folderPath)
                    .filter(Files::isRegularFile)
                    .map(x -> x.toFile())
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

    // 从指定的文件全路径获取.class类型的全包路径
    public static List<String> getClassNamesFromFiles(List<File> fileList) {
        List<String> classNameList = new ArrayList<>();
        for (File file: fileList) {
            String filepath = file.getAbsolutePath();
            if (filepath.endsWith(".class")) {
                String className = filepath.substring(filepath.indexOf("main"), filepath.indexOf(".class"));
                classNameList.add(className.replace("/", "."));
            }
        }
        return classNameList;
    }
}
