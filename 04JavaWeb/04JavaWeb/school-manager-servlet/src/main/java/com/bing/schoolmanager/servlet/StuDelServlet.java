package com.bing.schoolmanager.servlet;

import com.alibaba.fastjson.JSON;
import com.bing.schoolmanager.pojo.ReturnData;
import com.bing.schoolmanager.service.StudentServie;
import com.bing.schoolmanager.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//删除学生
@WebServlet("/delStu")
public class StuDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求体的编码（该设置只对POST请求有效），否则提交的中文数据会出现乱码
        req.setCharacterEncoding("UTF-8");
        // 设置响应内容的类型
        resp.setContentType("application/json;charset=UTF-8");
        // 拿到学号参数
        String studentNo = req.getParameter("studentNo");

        StudentServie studentServie = new StudentServiceImpl();
        int rows = studentServie.deleteStudent(studentNo);
        if(rows>0){
            resp.getWriter().write(
                    JSON.toJSONString(
                            new ReturnData(1,"删除成功",null)
                    )
            );
        }else{
            resp.getWriter().write(
                    JSON.toJSONString(
                            new ReturnData(0,"删除失败",null)
                    )
            );
        }

    }
}
