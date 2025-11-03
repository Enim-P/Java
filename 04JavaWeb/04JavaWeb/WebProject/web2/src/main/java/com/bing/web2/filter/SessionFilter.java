package com.bing.web2.filter;

import com.bing.web2.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 这里定义一个过滤器，过滤所有的请求
// 所以请求都必须要先走当前过滤器，当前过滤器通过后，才能访问请求的资源（servlet、jsp、html、静态资源）
@WebFilter("/*")
public class SessionFilter implements Filter {

    //doFilter就是过滤器方法，任何请求都会先走该方法
    @Override
    public void doFilter(ServletRequest sreq, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("验证Session的过滤器");
        HttpServletRequest req = (HttpServletRequest)sreq;

        // 获取请求路径
        String url = req.getRequestURL().toString();
        // 判断请求的路径是否是/session
        if(url.endsWith("/session") || url.endsWith("/city") || url.endsWith(".jsp")){
            // 放行
            filterChain.doFilter(req,resp);
        }

        // 获取当前客户端在服务器端的Session
        HttpSession session = req.getSession();
        // 拿到在Session中存储的用户对象
        User user = (User)session.getAttribute("user");
        if(user!=null){
            // 通过调用filterChain的doFilter方法放行
            filterChain.doFilter(req,resp);
        }

    }
}
