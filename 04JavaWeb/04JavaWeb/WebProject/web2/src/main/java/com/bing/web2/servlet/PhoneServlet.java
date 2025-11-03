package com.bing.web2.servlet;

import com.bing.web2.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/phone")
public class PhoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");

        // 获取当前客户端在服务器端的Session
        HttpSession session = req.getSession();
        // 拿到在Session中存储的用户对象
        User user = (User)session.getAttribute("user");
        if(user!=null){
            resp.getWriter().write("<h2>手机列表</h2>");
            resp.getWriter().write("<h2>苹果手机</h2>");
            resp.getWriter().write("<h2>三星手机</h2>");
            resp.getWriter().write("<h2>OPPO手机</h2>");
        }else{
            resp.getWriter().write("<h2>用户信息不能为空！</h2>");
        }

    }
}
