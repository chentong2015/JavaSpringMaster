package com.ctong.springboot.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterInterceptor implements HandlerInterceptor {

    /**
     * 根据request请求的参数, 来渲染页面的数据: 直接在request中添加Attribute, 适用所有的controller
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("greeting", "Hope you well");
        String location = request.getParameter("name");
        if (location != null) {
            request.setAttribute("name", location);
        }
        return true;
    }
}
