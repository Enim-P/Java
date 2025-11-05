package com.bing.schoolmanager.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.schoolmanager.pojo.ReturnData;
import com.bing.schoolmanager.pojo.Student;
import com.bing.schoolmanager.service.StudentServie;
import com.bing.schoolmanager.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 查询学生列表
@WebServlet("/stuList")
public class StuListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应内容的类型
        resp.setContentType("application/json;charset=UTF-8");
        // 获取学生姓名
        String studentName = req.getParameter("studentName");
        if(studentName==null){
            studentName = "";
        }
        StudentServie studentServie = new StudentServiceImpl();
        // 获取学生列表
        List<Student> students = studentServie.getStudentsByName(studentName);
        ReturnData retData = ReturnData.success("操作成功",students);
        resp.getWriter().write(JSON.toJSONString(retData));
    }
}
