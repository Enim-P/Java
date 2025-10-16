package com.bing.test02;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // 在try的()里面定义的对象，不需要显式释放资源，在try结束后会自动释放
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
                ){
            //定义sql语句
            String sql = "select * from subject";
            //执行sql语句，返回结果集对象
            ResultSet set = statement.executeQuery(sql);
            //查看结果
            while(set.next()){
                System.out.println(set.getObject("subjectId")+" "+
                        set.getObject("subjectName")+" "+
                        set.getObject("classHour")+" "+
                        set.getObject("gradeId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
