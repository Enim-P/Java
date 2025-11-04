package com.bing.schoolmanager.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.schoolmanager.pojo.ReturnData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 验证是否登录
@WebServlet("/ckLogin")
public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容的类型
        resp.setContentType("application/json;charset=UTF-8");

        // 从session中获取当前登录用户的信息
        Object admin = req.getSession().getAttribute("admin");
        // 如果存在就表示在线状态
        if(admin!=null){
            resp.getWriter().write(JSON.toJSONString(new ReturnData(1,"在线",null)));
        }else{
            resp.getWriter().write(JSON.toJSONString(new ReturnData(0,"离线",null)));
        }
    }
}
