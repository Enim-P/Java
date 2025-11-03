package com.bing.web2.servlet;

import com.bing.web2.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 4. session -> three -> exit -> web.xml Session相关操作
// Cookie是保存的客户端的浏览器上的数据
// Session是给每个客户端在服务器上保存的数据
// 什么样的数据适合用Session存储呢？
// 比如用户登录成功后，需要在服务器上存储一份用户信息，因为用户之后的所有操作都要知道是哪个具体的用户在操作
// 比如用户购买商品，需要在订单中提交用户的Id，这时就可以从Session中拿到登录用户信息的id
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应体的类型
        resp.setContentType("text/html;charset=UTF-8");

        // 获取请求参数
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        if(username==null || age==null){
            resp.getWriter().write("请提交用户信息！");
        }else{
            // 创建一个User对象，保存请求参数
            User user = new User(username,Integer.valueOf(age));
            // 获取当前客户端在服务器端的Session
            HttpSession session = req.getSession();
            // 在Sessdion中保存用户对象
            session.setAttribute("user",user);
            resp.getWriter().write("用户信息存储成功！");
        }
    }
}
