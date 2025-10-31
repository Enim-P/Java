package com.bing.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 退出系统的Servlet
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");
        // 拿到所有的Cookie
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            // 让验证登录的Cookie过期
            if(cookie.getName().equals("loginId")){
                cookie.setMaxAge(0);  //立刻过期
                resp.addCookie(cookie);
            }
            if(cookie.getName().equals("loginPwd")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        resp.getWriter().write("<script>" +
                "alert('成功退出！');" +
                "location.href = 'index.html'"+
                "</script>");
        //resp.sendRedirect("index.html");
    }
}
