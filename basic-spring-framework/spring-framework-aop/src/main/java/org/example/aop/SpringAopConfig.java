package org.example.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
// 1. proxyTargetClass = false 默认使用JdkDynamicAopProxy，而不是cglib代理
// 2. exposeProxy = false      默认不将Proxy暴露给ThreadLocal，无法通过AopContext.currentProxy()获取
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.example.aop")
public class SpringAopConfig {


}
