package com.bing.schoolmanager.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.schoolmanager.pojo.ReturnData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 退出
@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容的类型
        resp.setContentType("application/json;charset=UTF-8");
        // 清空所有session信息
        req.getSession().invalidate();
        resp.getWriter().write(JSON.toJSONString(new ReturnData(1,"成功退出",null)));
    }
}
