package com.bing.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/two")
public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");
        // 如果获取不到city参数，返回的是null
        String city = req.getParameter("city");

        // 拿到当前请求上下文中存储的数据
        String name = (String) req.getAttribute("name");
        resp.getWriter().write(name);
        if("南京".equals(city)){
            resp.getWriter().write("这里是江苏省省会");
        }else{
            resp.getWriter().write("不确定是什么地方");
        }
    }
}
