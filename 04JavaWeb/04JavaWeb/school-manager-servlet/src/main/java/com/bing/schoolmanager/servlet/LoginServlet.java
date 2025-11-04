package com.bing.schoolmanager.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.schoolmanager.pojo.Admin;
import com.bing.schoolmanager.pojo.ReturnData;
import com.bing.schoolmanager.service.AdminService;
import com.bing.schoolmanager.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 登录
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求体的编码（该设置只对POST请求有效），否则提交的中文数据会出现乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应内容的类型
        //resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        // 获取账号
        String loginId = req.getParameter("loginId");
        // 获取密码
        String loginPwd = req.getParameter("loginPwd");

        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.getAdminByLoginId(loginId);

        ReturnData retData = null;
        if(admin!=null){
            if(admin.getLoginPwd().equals(loginPwd)){
                // 判断是否记住我
                String ckMe = req.getParameter("ckMe");
                // 如果记住我，添加Cookie保存登录信息，发送给浏览器
                Cookie cookie1 = new Cookie("loginId",loginId);
                Cookie cookie2 = new Cookie("loginPwd",loginPwd);
                Cookie cookie3 = new Cookie("ckMe",ckMe);
                // 如果没有记住我，设置Cookie立刻过期
                if("false".equals(ckMe)){
                    cookie1.setMaxAge(0);
                    cookie2.setMaxAge(0);
                    cookie3.setMaxAge(0);
                }
                // 将Cookie发送给浏览器
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                resp.addCookie(cookie3);

                retData = ReturnData.success("登录成功",admin);
                //登录成功后，将当前用户信息保存到session中
                req.getSession().setAttribute("admin",admin);
            }else{
                retData = ReturnData.error("密码错误");
            }
        }else{
            retData = ReturnData.error("账号错误");
        }
        resp.getWriter().write(JSON.toJSONString(retData));
    }
}
