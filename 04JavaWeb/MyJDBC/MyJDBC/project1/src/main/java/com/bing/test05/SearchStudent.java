package com.bing.test05;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入学生的姓名（模糊查询）：");
        String name = input.next();
        // 创建一个学生集合
        List<Student> students = new ArrayList<>();
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            //定义sql语句
            String sql = "select * from student where studentName like '%"+name+"%'";
            //执行sql语句，返回结果集对象
            ResultSet set = statement.executeQuery(sql);
            //查看结果
            while(set.next()){
                // 创建学生对象
                Student student = new Student();
                student.setStudentNo(set.getString("studentNo"));
                student.setLoginPwd(set.getString("loginPwd"));
                student.setStudentName(set.getString("studentName"));
                student.setSex(set.getString("sex"));
                student.setGardeId(set.getInt("gradeId"));
                student.setPhone(set.getString("phone"));
                student.setAddress(set.getString("address"));
                student.setBornDate((LocalDateTime)set.getObject("bornDate"));
                student.setAddress(set.getString("email"));
                student.setIdentityCard(set.getString("identityCard"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 遍历集合打印每个学生对象
        students.forEach(System.out::println);
    }
}
