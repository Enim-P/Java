package com.bing.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/city")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("city servlet ....");
        resp.getWriter().write("<h2>city servlet ....</h2>");
    }
}
