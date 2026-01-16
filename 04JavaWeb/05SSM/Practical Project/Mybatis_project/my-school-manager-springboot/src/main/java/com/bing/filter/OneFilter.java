package com.bing.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 1号过滤器
 */
@Slf4j
@WebFilter(urlPatterns = "/*")   //拦截所有请求
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("1号过滤器拦截前....");
        // 放行
        chain.doFilter(request,response);
        log.info("1号过滤器拦截后....");
    }
}
