package com.bing.web2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/city")  //只拦截city请求
public class AFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A过滤器 start");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("A过滤器 end");
    }
}
