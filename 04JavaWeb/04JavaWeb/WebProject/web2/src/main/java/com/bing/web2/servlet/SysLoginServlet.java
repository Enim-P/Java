package com.bing.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 3. syslogin -> exit Cookie相关操作
@WebServlet("/syslogin")
public class SysLoginServlet extends HttpServlet {
    // 使用Cookie实现自动登录功能
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId="";   //登录名
        String loginPwd="";  //密码
        // Cookie是服务器端创建的一份数据，发送给浏览器进行存储
        // 浏览器的每次请求都会携带它存储的Cookie再回到服务器
        Cookie[] cookies = req.getCookies();
        // 如果没有Cookie信息，直接重定向到登录页
        if(cookies==null){
            // 重定向到登录页面
            resp.sendRedirect("syslogin.html");
            return;
        }
        // 如果有Cookie信息
        for(Cookie cookie : cookies){
            // 需要从cookie中拿到登录名和密码
            if(cookie.getName().equals("loginId")){
                loginId = cookie.getValue();
            }
            if(cookie.getName().equals("loginPwd")){
                loginPwd = cookie.getValue();
            }
        }
        // 判断登录名和密码是否正确
        if(loginId.equals("test") && loginPwd.equals("123456")){
            // 登录成功后跳转到首页
            resp.sendRedirect("index.html");
        }else{
            // 重定向到登录页面
            resp.sendRedirect("syslogin.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理Post请求体中文乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");

        // 获取请求参数
        String loginId = req.getParameter("loginId");   //登录名
        String loginPwd = req.getParameter("loginPwd");  //密码

        // 判断是否登录成功
        if(loginId.equals("test") && loginPwd.equals("123456")){
            // 判断是否记住我
            String ckme = req.getParameter("ckme");
            if(ckme!=null){
                // 使用Cookie保存登录名和密码，并将Cookie发送给浏览器存储
                Cookie cookie1 = new Cookie("loginId",loginId);
                Cookie cookie2 = new Cookie("loginPwd",loginPwd);
                // 设置Cookie的过期时间，单位是秒，不设置时间的花Cookie会一直存在
                // cookie1.setMaxAge(1000);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
            }
            // 登录成功后跳转到首页
            // req.getContextPath()获取的是当前容器根路径（可以省略）
            resp.sendRedirect(req.getContextPath()+"index.html");
        }else{
            resp.getWriter().write("登录失败！");
        }
    }
}
