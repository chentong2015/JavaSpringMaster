package com.ctong.springboot;

// 1. Initializer启动器(start.spring.io), 创建指定的项目模板
// 2. Embedded Tomcat嵌入式Web容器不支持打包jsp文件到jar文件中
//    2.1 使用war插件将JSP打包成war
//    2.2 使用别的前端渲染引擎
// 3. TODO: Spring Boot热部署 > spring-boot-devtools
//    不需要重启Web服务器就可以保证各项文件修改后便立即生效
//    3.1 如果是template file, 则将会即时显示出来
//    3.2 如果改变的是class，则会重新编译在启动
public class BaseSpringBoot {

    /**
     * Spring Boot 项目架构：
     * .mvn/                                   > wrapper sub folder
     * --- wrapper/                            > maven wrapper jsr and properties 在不安装maven的情况下，在console启动app !!
     * libs/                                   > 包含额外的jar类库
     * src/
     * --- main/                               > main subfolder contains java and resources folder
     * ------ java/
     * ---------- com.example.basicspringboot/
     * ------ resources/                       > main resources
     * ---------- static                       > static resources (css, js, html, images)  被spring boot自动检测到的静态资源
     * ---------- templates/                   > templates folder (com.ctong.springboot.thymeleaf, groovy ..)   被spring boot自动检测到的动态content
     * ---------- application.properties       > application properties file               配置文件: database, URL, server ports...
     * --- test/                               > for unit tests
     * ------ java/
     * mvnw                                    > startup batch script used for running from console
     * mvnw.cmd                                > startup batch script used for running from console (windows)
     * pom.xml
     */
}
