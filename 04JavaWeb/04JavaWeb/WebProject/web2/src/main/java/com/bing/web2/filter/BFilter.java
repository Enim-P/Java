package com.bing.web2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 如果项目中添加了多个过滤器，每个过滤器都都会执行
// 执行的顺序是根据过滤器名称降序排列（字符串的降序排列算法）
@WebFilter("/city")
public class BFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("B过滤器 start");

        // 放行上面是拦截前处理
        filterChain.doFilter(servletRequest,servletResponse);
        // 放行下面是拦截后处理

        System.out.println("B过滤器 end");
    }
}
