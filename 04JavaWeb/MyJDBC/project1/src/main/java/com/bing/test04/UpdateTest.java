package com.bing.test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {
    public static void main(String[] args) {
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            String sql = String.format("update subject set subjectName='%s'," +
                    "classHour='%s' where subjectId='%s'",
                    "使用Vue企业级技术开发企业应用",200,11);
            // 修改也是使用executeUpdate方法
            int rows = statement.executeUpdate(sql);
            if(rows>0){
                System.out.println("课程修改成功！");
            }else{
                System.out.println("课程修改失败！");
            }
        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
