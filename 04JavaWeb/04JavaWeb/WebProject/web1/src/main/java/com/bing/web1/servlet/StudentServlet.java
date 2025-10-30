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
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {


    // get做查询
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentMapper studentMapper = MybatisUtil.getSession(true).getMapper(StudentMapper.class);
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
        StudentMapper studentMapper = MybatisUtil.getSession(true).getMapper(StudentMapper.class);
        // 除了post请求传递中文参数中文乱码问题
        req.setCharacterEncoding("UTF-8");
        // 响应的内容类型是application/json，是一个json格式的数据
        resp.setContentType("application/json;charset=UTF-8");
        // 拿到前端传递的参数
        String studentNo = req.getParameter("studentNo");
        String loginPwd = req.getParameter("loginPwd");
        String studentName = req.getParameter("studentName");
        String sex = req.getParameter("sex");
        int gradeId = Integer.valueOf(req.getParameter("gradeId"));
        String phone = req.getParameter("phone");
        LocalDateTime bornDate = LocalDateTime.now();
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String identityCard = req.getParameter("identityCard");
        // 创建一个学生对象
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        student.setStudentName(studentName);
        student.setSex(sex);
        student.setGradeId(gradeId);
        student.setPhone(phone);
        student.setBornDate(bornDate);
        student.setEmail(email);
        student.setAddress(address);
        student.setIdentityCard(identityCard);
        int rows = studentMapper.addStudent(student);
        if(rows>0){
            resp.getWriter().write("ok");
        }else{
            resp.getWriter().write("no");
        }

    }
}
