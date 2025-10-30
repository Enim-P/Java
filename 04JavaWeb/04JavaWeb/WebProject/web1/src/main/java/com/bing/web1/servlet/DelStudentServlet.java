package com.bing.web1.servlet;

import com.bing.web1.mapper.StudentMapper;
import com.bing.web1.util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 专门用于删除学生
@WebServlet("/delstudent")
public class DelStudentServlet extends HttpServlet {


    // 接收前端传过来的学号，根据学号删除该学生
    // 删除成功返回ok，删除失败返回no
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentMapper studentMapper = MybatisUtil.getSession(true).getMapper(StudentMapper.class);
        // 设置响应类型
        resp.setContentType("application/json;charset=UTF-8");
        // 获取学号
        String studentNo = req.getParameter("studentNo");
        // 根据学号删除学生
        int rows = studentMapper.delStudent(studentNo);
        if(rows>0){
            resp.getWriter().print("ok");
        }else{
            resp.getWriter().print("no");
        }
    }
}
