package com.example.main;

// XML based Configuration 使用XML配置的特点
// 1. Centralize config metadata 很容易看到整个的配置, 容易修改
// 2. 位于Java Class之外, 对于xml配置文件的更改，不需要修改代码和重新编译
// 3. Verbose冗长，需要理解偏背后的逻辑   
// 4. Typing严格的字符输入敏感，容易造成错误，并不是类型安全的

// Annotation Based configurations ==> 适应之后，应该转成使用Annotations
// 1. 类型安全，比XML更加的短小
// 2. 比较难从整体上宏观的去注意整个的配置metadata
// 3. 需要重新编译
public class CompareXmlAndAnnotaionConfig {

    // @Value annotations: for property value injection
    // @Value("${nameOfProperty}") 从分离的.properties文件中注入属性值

    // @Configuration 使用该注解能够结合两种配置方法的优点 !!!
    // 1. Java based configuration class 编译安全
    // 2. 专注于大部分的annotation configuration
    // 3. 同时能够将配置文件进行分离到separate file: .properties

}
