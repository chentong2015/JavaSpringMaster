package com.spring.boot.basic.demo.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interceptor: 拦截器，在所有request请求到来时执行
 * 1. Check admin permission, check security, change globally used parameters
 * 2. 可以根据不同的页面提供不同的信息，加载不同的数据
 * 3. 通过Interceptor将messages/data渲染到多个请求的页面，减少Controller层的重复代码 !!
 */
@Slf4j
public class BaseInterceptor implements HandlerInterceptor {

    // 在Handler处理之前执行，判断是否中断或者继续执行请求，重定向页面
    // Object Handler: the com.ctong.springboot.controller whose method will execute after preHandle method
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断请求的Session中是否有用户登录凭证: 在用户成功登录时构建HttpSession
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/game");
            return false;
        }
        return true;
    }

    //在Controller(handler)执行指定的方法后执行, 在View渲染生成之前执行
    // modelAndView: holder of model and views in Spring MVC 同时包含VIEW和model内容, Controller最后返回的
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("Post handle method called");
        log.info(modelAndView.getViewName());
    }

    // 在request请求完全结束之后执行, 在View完全生成之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        log.info("After completion ...");
    }
}
