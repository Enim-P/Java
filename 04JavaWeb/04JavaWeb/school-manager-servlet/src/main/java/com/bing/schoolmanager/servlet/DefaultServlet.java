package com.bing.schoolmanager.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")   // 覆盖默认访问资源
public class DefaultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向到登录页面

        // 获取请求的最后一个字符
        String path = req.getRequestURI().substring(req.getContextPath().length());
        if("/".equals(path)){
            // 从session中获取当前登录用户的信息
            Object admin = req.getSession().getAttribute("admin");
            // 如果是在线状态跳转到index，离线状态跳转到login
            if(admin!=null){
                resp.sendRedirect(req.getContextPath()+"/index.html");
            }else{
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }
            return;
        }

        // 处理静态资源请求（让默认Servlet处理）
        // default是Tomcat中默认处理静态资源的Servlet名称
        getServletContext().getNamedDispatcher("default").forward(req,resp);
    }
}
