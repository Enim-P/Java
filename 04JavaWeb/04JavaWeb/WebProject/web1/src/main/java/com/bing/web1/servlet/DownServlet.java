package com.bing.web1.servlet;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//下载
@WebServlet("/download")
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应的内容类型是png图片
        resp.setContentType("image/png");
        // 通过相应对象返回一个输出流
        OutputStream outputStream = resp.getOutputStream();
        // 将指定的资源转为一个输入流
        InputStream inputStream = Resources.getResourceAsStream("dog.png");
        // 直接将输入流copy给输出流
        IOUtils.copy(inputStream,outputStream);
    }
}
