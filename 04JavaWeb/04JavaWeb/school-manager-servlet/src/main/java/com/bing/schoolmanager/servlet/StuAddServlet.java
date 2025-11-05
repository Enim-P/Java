package com.bing.schoolmanager.servlet;

import cn.hutool.core.date.DateUtil;
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

// 添加学生
@WebServlet("/addStu")
public class StuAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求体的编码（该设置只对POST请求有效），否则提交的中文数据会出现乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应内容的类型
        resp.setContentType("application/json;charset=UTF-8");
        // 获取参数
        String studentNo = req.getParameter("studentNo");
        String loginPwd = req.getParameter("loginPwd");
        String studentName = req.getParameter("studentName");
        String sex = req.getParameter("sex");
        String gradeId = req.getParameter("gradeId");
        String phone = req.getParameter("phone");
        String bornDate = req.getParameter("bornDate");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String identityCard = req.getParameter("identityCard");
        // 创建学生对象组织数据
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        student.setStudentName(studentName);
        student.setSex(sex);
        student.setGradeId(Integer.valueOf(gradeId));
        student.setPhone(phone);
        student.setBornDate(DateUtil.parseLocalDateTime(bornDate,"yyyy-MM-dd"));
        student.setEmail(email);
        student.setAddress(address);
        student.setIdentityCard(identityCard);

        StudentServie studentServie = new StudentServiceImpl();
        int rows = studentServie.addStudent(student);
        if(rows>0){
            resp.getWriter().write(
                    JSON.toJSONString(
                            new ReturnData(1,"添加成功",null)
                    )
            );
        }else{
            resp.getWriter().write(
                    JSON.toJSONString(
                            new ReturnData(0,"添加失败",null)
                    )
            );
        }
    }
}
