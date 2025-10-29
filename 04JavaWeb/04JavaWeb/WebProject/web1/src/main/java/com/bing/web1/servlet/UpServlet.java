package com.bing.web1.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

// 上传
@MultipartConfig    //注意：必须添加该注解，表示此Servlet用于处理文件上传请求
@WebServlet("/user/up")
public class UpServlet extends HttpServlet {
    // 文件上传必须使用post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一个输出流，指定将上传的资源输出到哪里
        try(FileOutputStream outputStream = new FileOutputStream("/Users/a1/Desktop/mine/带班/班级授课/KG37/04JavaWeb/04JavaWeb/WebProject/web1/uploadfile/"+new Date().getTime()+".jpg")){
            // 获取上传的资源包
            Part part = req.getPart("photo");
            // 从资源包里面拿到输入流
            InputStream inputStream = part.getInputStream();
            // 将输入流copy给输出流
            IOUtils.copy(inputStream,outputStream);
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("上传成功！");
    }
}
