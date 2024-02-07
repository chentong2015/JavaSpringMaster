package com.example.main.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO. 自定义Spring Config配置中的属性，将会被自动注入
// 可以直接在application.properties中配置 storage.location=xxx/folder
@ConfigurationProperties("storage")
public class StorageProperties {

    // Server端保存上传文件的目录路径
    private String location = "spring-boot-basic/spring-boot-upload-download-files/folder-upload";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
