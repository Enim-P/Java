package com.bing.web1.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.web1.mapper.StudentMapper;
import com.bing.web1.pojo.Student;
import com.bing.web1.util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    StudentMapper studentMapper = MybatisUtil.getSession(true).getMapper(StudentMapper.class);

    // get做查询
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 响应的内容类型是application/json，是一个json格式的数据
        resp.setContentType("application/json;charset=UTF-8");
        // 获取学生的姓名
        String studentName = req.getParameter("studentName");
        // 获取学生集合
        List<Student> students = studentMapper.studentList(studentName);
        // 将学生集合转为json格式的字符串
        String str = JSON.toJSONString(students);
        // 将json格式的学生数组响应给前端
        resp.getWriter().write(str);
    }

    // post做添加
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 响应的内容类型是application/json，是一个json格式的数据
        resp.setContentType("application/json;charset=UTF-8");
        String studentNo = req.getParameter("studentNo");
        System.out.println(studentNo);
    }
}
