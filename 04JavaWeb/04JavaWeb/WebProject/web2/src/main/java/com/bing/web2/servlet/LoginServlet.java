package com.bing.web2.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理Post请求体中文乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");
        String loginId = req.getParameter("loginId");
        String loginPwd = req.getParameter("loginPwd");

        // 这里使用请求对象的setAttribute方法存储一份数据
        // req.setAttribute("name","LoginServlet");
        // 通过getServletContext方法获取ServletContext容器
        // 注意：在整个项目中，getServletContext()方法返回的都是同一个ServletContext容器
        ServletContext context = getServletContext();
        context.setAttribute("name","全局上下文容器");

        if(loginId.equals("test") && loginPwd.equals("123456")){
            //resp.getWriter().write("登录成功！");
            //sendRedirect方法用于重定向
            //重定向是一种前端行为，是后端指定了前端跳转的行为
            resp.sendRedirect("time");
            //resp.sendRedirect("index.html");
        }else{
            resp.getWriter().write("登录失败！");
        }
    }
}
