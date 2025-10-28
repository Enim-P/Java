package com.bing.web1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet接口提供的是对所有请求的操作，它有一个直接实现的抽象类GenericServlet
// 我们在开发JavaWeb应用程序时，绝大部分都是在操作HTTP请求，所以它提供了一个专门用于处理HTTP请求的子类
// GenericServlet提供了一个子类HttpServlet，用它操作HTTP请求
@WebServlet("/three")
public class ThreeServlet extends HttpServlet {
    // 常见的HTPP请求方式包括：GET POST PUT DELETE

    // GET请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        //响应数据
        resp.getWriter().write("<h2>响应的数据了！<h2>");
    }
}
