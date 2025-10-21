package com.bing.test04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {
    public static void main(String[] args) {
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            String sql1 = "insert into subject(subjectName,classHour,gradeId)" +
                    " values('高等数学','128','3')";
            String sql2 = "insert into subject(subjectName,classHour,gradeId)" +
                    " values('牛津英语','158','3')";
            String sql3 = String.format("update subject set subjectName='%s'," +
                            "classHour='%s' where subjectId='%s'",
                    "使用JS企业级技术开发企业应用",220,11);
            // addBatch方法，添加批处理
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);
            // 执行批处理（返回一个数组，数组中存储的是每条sql语句受影响的行数）
            int[] rows = statement.executeBatch();
            System.out.println("操作成功！");
        } catch (SQLException e) {
            System.out.println("发生异常！！！！");
        }
    }
}
