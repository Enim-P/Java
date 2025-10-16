package com.bing.test03;

import java.sql.*;

public class Main {
    // 执行添加操作
    public static void main(String[] args) {
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            // 插入一个年级信息
            String sql = "insert into Grade(gradeName) values('大四')";
            // 数据库执行对象的executeQuery方法，执行查询sql语句，返回结果集对象
            // 数据库执行对象的executeUpdate方法，执行增删改sql已经，返回受影响的行数
            int rows = statement.executeUpdate(sql);
            if(rows>0){
                System.out.println("年级添加成功！");
            }else{
                System.out.println("那就添加失败！");
            }
        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
