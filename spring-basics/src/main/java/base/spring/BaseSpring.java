package base.spring;

/**
 * Java企业开发技术:
 * J2EE: 从Java 2.0开始  ==>  JEE: 之后Edition技术版本统称 (JEE的版本一般比Java的版本要低一个版本)
 * --> JSP (Java ServerPage) Java开发企业应用的第一代技术: 代码和页面标签混合，不利于维护
 * .    ====> Microsoft同期技术: Active ServerPage -> ASP.NET
 * --> JSF (Java ServerFaces): 以一种MVC的框架来构建
 * --> Java MVC: 从Java 9发布
 * JEE逐渐失去热度  ==>  JEE可能的发展 > Oracle贡献给Apache委员会, 成为完全开源的技术，保持繁盛
 * --> Oracle在收购SUN公司之后, 定义的标准没有充分实施, 关闭开源社区, 陷入版权争端, 教学课本限制 (从Java变成Python语言的课本)
 * --> 替代品太强了：Spring(注：弹簧)框架规则灵活，且没有诸多JEE的限制 ==> 实际上业界标准
 * .
 * TODO: Spring MVC: Spring Web整合了Spring MVC
 * --> MVC；一种可大可小的架构, 对于Spring来说，指的是程序架构，用一套原理(放大到程序维度)构建起来的项目 ==> ios ui mvc
 * --> Spring: 框架非常大, 模块非常多
 * 1. AOP (Aspect Oriented Programming): 面向方面(横切面)编程, 在程序的纵剖面做些什么事情 ==> logging, authorization, security
 * 2. Spring Core 最贴近Java底层，灵活(反射)的做配置
 * Spring MVC 不足之处
 * 1. View页面层，渲染引擎(JSP, JSF均过时, 比较重): Thymeleaf(轻便), Freemarker / JSTL ...
 * 2. Spring擅长中间逻辑层的构建
 * 3. 数据库交互: JPA (Java持久层API, 标准的API, 有利于框架的更换，抽象隔离) Hibernate / MyBatis
 */
public class BaseSpring {

    /**
     * Spring 5 New Feature ==> Java EE 8
     * 1. Spring 5 is base on Java 8
     * 2. Core framework revision / Core container updates: support component index to classpath scanning
     * 3. Functional programming with Kotlin (object oriented)
     * 4. Reactive Programming Model
     * ---- "Reactive Streams" is an API, provides common API for reactive programming implementations
     * ---- JPA for Hibernate：JPA is the API and "Hibernate" is the implementation
     * 5. Unit Test for JNuit 5
     * 6. Add Library Support, and not support Velocity, Portlet, JasperReports ..
     */

    // TODO: 测试时，构建的单元测试必须全部通过
    // 只有当项目构建成功之后，/resources目录下的文件会被自动打包到/target/中
    // 然后使用程序对资源进行加载和读取

    /**
     * Java配置文件是如何运作的 ? 使文件随着程序一起发布
     * 创建resource文件夹，并标记成Resources，在资源访问时需要添加resources文件夹路径
     * ===> 普通Java项目，当使用File System文件系统来进行访问时 !!!
     * 1. Projects Settings > Modules > ProjectName > Sources       ->  src蓝色的sources中的源文件将会被javac编译
     * 2. Projects Settings > Modules > ProjectName > Tests         ->  执行单元测试时，绿色的文件夹中的才会被编译
     * 3. Projects Settings > Modules > ProjectName > Resources     ->  随着编译，生成(copy)到结果中的资源文件, 但是不会被编译处理
     * 4. Projects Settings > Modules > ProjectName > Test Resources -> 只针对测试所用的资源
     * 5. Projects Settings > Modules > ProjectName > Excluded       -> 编译生成后的文件夹 /out /target
     */
}
