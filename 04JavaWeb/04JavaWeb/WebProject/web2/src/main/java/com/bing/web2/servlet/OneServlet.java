package com.bing.web2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1. one -> two 是请求转发
@WebServlet("/one")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getRequestDispatcher方法，设置请求转发
        // 请求转发是后端行为，是当前Servlet将请求转发给了另一个Servlet，前端是不知道的
        // 前端的地址依然是one?city=XXX，后端已经将请求转发给two了

        // 通过setAttribute方法，可以给当前请求附加数据
        // 将我能处理的结果先存储起来，再将请求转发给下一个Servlet，下一个Servlet能拿到我处完的结果
        req.setAttribute("name","OneServlet");

        // forward方法，用于将当前方法中的请求对象和响应对象传递给下一个请求
        req.getRequestDispatcher("/two").forward(req,resp);
    }
}
