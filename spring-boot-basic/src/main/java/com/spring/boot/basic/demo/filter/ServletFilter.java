package com.spring.boot.basic.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletFilter implements Filter {

    // 自定义过滤servletRequest请求
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(request, response);
        } catch (ServletException exception) {
            // 提供日志的输出
            // logError(request, response, exception);
            throw exception;
        }
    }
}
