package com.bing.web1.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// 通过实现Servlet来进行动态网页响应
// 它提供了对TCP协议的封装，实现Servlet接口定义Servlet

// 通过@WebServlet注解，注册Servlet（推荐用法）
@WebServlet("/one")
public class OneServlet implements Servlet {
    // 调用Servlet时，执行的顺序分别是：1.构造函数 2.init 3.service
    // 反复调用Servlet时，会反复执行service，这个service方法就是当前Servlet提供的服务
    // destroy方法，在服务器停止时会执行
    public OneServlet() {
        System.out.println("OneServlet构造函数");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("OneServlet - init初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("OneServlet - getServletConfig");
        return null;
    }

    // 当前Servlet提供的服务方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("OneServlet - service");
        // ServletRequest：请求参数
        // ServletResponse：响应参数
        // 将servletRequest强转成对应的子类HttpServletRequest，因为当前是HTTP请求
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("请求协议："+request.getProtocol());
        System.out.println("请地址的IP地址："+request.getRemoteAddr());
        System.out.println("请求方式："+request.getMethod());
        // 获取请求头信息
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name+": "+request.getHeader(name));
        }
        // 将ServletResponse强转成对应的字类HttpServletResponse，因为当前是HTTP请求
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 设定内容类型以及编码格式，通过设置响应头设置
        // 普通的HTML文本使用text/html
        // charset=UTF-8是编码格式
        response.setHeader("Content-type","text/html;charset=UTF-8");
        // 向客户端响应数据
        response.getWriter().write("<h2>我是响应的内容！</h2>");
    }

    @Override
    public String getServletInfo() {
        System.out.println("OneServlet - getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("OneServlet - destroy销毁方法");
    }
}
