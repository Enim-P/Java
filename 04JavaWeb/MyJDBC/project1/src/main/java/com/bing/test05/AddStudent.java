package com.bing.test05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入学号：");
        String studentNo = input.next();
        System.out.print("请输入密码：");
        String loginPwd = input.next();
        System.out.print("请输入姓名：");
        String studentName = input.next();
        System.out.print("请输入性别：");
        String sex = input.next();
        String gradeId = "3";
        System.out.print("请输入电话：");
        String phone = input.next();
        System.out.print("请输入地址：");
        String address = input.next();
        System.out.print("请输入生日：");
        String bornDate = input.next();
        System.out.print("请输入邮箱：");
        String email = input.next();
        System.out.print("请输入身份证号码：");
        String identityCard = input.next();
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            // 组织sql语句
            String sql = String.format("insert into student " +
                        "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                        studentNo,loginPwd,studentName,sex,gradeId,
                        phone,address,bornDate,email,identityCard);
            int rows = statement.executeUpdate(sql);
            if(rows>0){
                System.out.println("学生添加成功");
            }else{
                System.out.println("学生添加失败！");
            }
        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
