package com.bing.test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
    public static void main(String[] args) {
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            String sql = String.format("delete from grade where gradeId=4");
            // 删除也是使用executeUpdate方法
            int rows = statement.executeUpdate(sql);
            if(rows>0){
                System.out.println("年级删除成功！");
            }else{
                System.out.println("年级删除失败！");
            }
        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
