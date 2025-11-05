package com.bing.schoolmanager.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


// 过滤器
@WebFilter("/*")
public class OneFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        String[] filters = new String[]{"/",".js",".css","login.html","index.html",
                "/ckLogin","/login"};
        //判断是否为静态资源
        if(Arrays.stream(filters).filter(s->url.endsWith(s)).toArray().length==0){
            // 从session中获取当前登录用户的信息
            Object admin = req.getSession().getAttribute("admin");
            if(admin==null){
               return;
            }
        }
        chain.doFilter(req,res);
    }

}
