package com.bing.test07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
    public static void main(String[] args) {
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            String sql1 = "insert into grade(gradeName) values('一年级')";
            String sql2 = "insert into grade(gradeName) values('二年级')";
            String sql3 = "insert into grade(gradeName) values('三年级')";
            //关闭自动提交事务，改成手动提交
            connection.setAutoCommit(false);
            //执行sql语句
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);

            // 这里需要判断执行效果是否满足要求
            if(true){
                connection.commit();     //提交事务
            }else{
                //connection.rollback();   //回滚事务
            }



        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
