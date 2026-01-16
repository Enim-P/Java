package com.bing.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 2号过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/*")   //拦截所有请求
public class TwoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("2号过滤器拦截前....");
        chain.doFilter(request,response);
        log.info("2号过滤器拦截后....");
    }
}

/*
    如果定义多个过滤器，所以的过滤器会挨个执行，执行的顺序是按照过滤器的名称排序
*/