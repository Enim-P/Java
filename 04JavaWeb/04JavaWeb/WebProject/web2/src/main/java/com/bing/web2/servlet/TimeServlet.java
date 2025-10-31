package com.bing.web2.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 返回当前时间
@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将指定的日期字符串响应给前端
        resp.setContentType("text/html;charset=UTF-8");

        //String name = (String)req.getAttribute("name");
        //resp.getWriter().println(name);
        //从全局ServletContext容器中获取提前存储的数据
        ServletContext context = getServletContext();
        String name = (String)context.getAttribute("name");
        resp.getWriter().println(name);

        // 定义一个时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        // 将当前日期转为指定格式的字符串形式
        String date = dateFormat.format(new Date());

        resp.getWriter().write(date);
    }
}
