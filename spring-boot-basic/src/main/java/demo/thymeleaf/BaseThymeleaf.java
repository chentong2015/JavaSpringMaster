package demo.thymeleaf;

// Thymeleaf 3.0: 前端渲染引擎
// 1. server-side Java template (web) engine
// 2. Support processing of HTML, XML, JS and plain text, fragments

// https://www.geeksforgeeks.org/spring-boot-thymeleaf-with-example/
// https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-post-json-example
public class BaseThymeleaf {

    // Add Thymeleaf Dependency
    // Add xmlns:th="http://www.thymeleaf.org" to HTML Web Page

    // Thymeleaf Preprocessing 预处理表达式: view页面使用的变量，必须和model中提供的是一致的
    // 1. th:text="${__${T(main.com.ctong.springboot.util.AttributeNames).MAIN_MESSAGE}__}"
    //    内部的表示式会先处理, T()操作符使用Java instance，调用方法或者使用静态成员
    // 2. th:action="@{__${T(main.com.ctong.springboot.util.Mappings).PLAY}__}"
    //    使用在URLs上 th:action="@{ }"或者th:href="@{url}" 可直接在{ }中注明路径

    // Thymeleaf Fragment 可重用，可传参的片段
    // th:fragment="fragmentName" 声明fragment
    // th:insert="~{templateName :: fragmentName}"
    // th:replace="~{templateName :: fragmentName}" 将片段的内容替换当前标签下的内容
    // th:replace="fragments :: my_fragment(value1='a', defaultParameter='b')" 支持传递参数
    // th:include="templateName :: fragmentName"    将片段的内容直接引入
    // th:insert="${user.isAdmin()} ? ~{common :: admin-head} : ~{}"

    // Thymeleaf Decoupled template 将Thymeleaf的渲染逻辑和Html分离
    // logic file: .th.xml 包含模板逻辑的文件，该文件是独立的
}
