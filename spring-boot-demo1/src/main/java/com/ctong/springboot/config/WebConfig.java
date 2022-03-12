package com.ctong.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    /**
     * 没有使用Spring boot默认的资源路径                 ===> Spring Boot会默认配置Prefix到/src/main/resources/templates !!
     * 1. 需要配置ViewResolver解析路径到WEB-INF/下面     ===> 也可以在application.properties中配置 !!
     * 2. 由于JSP在Spring Boot中的限制，不使用JSP渲染界面
     */
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 1. Spring默认使用AcceptHandlerLocaleResolver       使用HTTP Header中提供的locale
     * 2. 自定义使用FixedLocaleResolve来固定locale的使用    spring.web.locale-resolver=fixed
     * 3. 自定义使用SessionLocaleResolver通过代码来使用     不在需要配置properties file
     * 4. 自定义使用HandlerInterceptorAdapter
     */
    @Bean
    public LocaleResolver localeResolver() {
        /**
         * SessionLocaleResolver将localhost:8080/?lang=fr中传递的local通过session来保存 ==> 在JSP file中自动使用cookies来追踪状态
         * localhost:8080/game;jsessionid=EHKI51KHSNKD5...
         * localhost:8080/game?lang=en 自定义更换
         */
        return new SessionLocaleResolver();
    }

    /**
     * 添加自定义的HandlerInterceptor拦截器: configure a list of mapped com.ctong.springboot.interceptors
     * 添加LocaleChangeInterceptor语言环境变更拦截器: 通过URL参数来动态改变UI语言 localhost:8080/?lang=fr
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(new BaseInterceptor());
        // registry.addInterceptor(new MasterInterceptor()).addPathPatterns("/game"); // 该Interceptor只针对指定的request进行拦截

        registry.addInterceptor(new LocaleChangeInterceptor()); // 使用默认的参数名称"locale"
        // LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // localeChangeInterceptor.setParamName("lang"); // 自定义设置URL路径中传递的参数名称
        // registry.addInterceptor(localeChangeInterceptor);
    }
}
