package com.bing.test01;

import java.sql.*;

public class Main {
    // JDBC是什么？Java Data Base Connectivity，其实就是java连接数据库的技术
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.导入mysql驱动jar包，这里我们使用maven构建工具导入（不再需要手动维护各个jar包的版本）
        // 2.加载驱动，从6.0之前的驱动可以不手动加载（我们当前项目导入的是8.0的驱动）
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            // 3. 创建数据库连接对象（通过驱动管理类创建）
            // 需要传递三个参数：连接URL 用户名 密码
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myschool",
                    "root",
                    "root1234");
            // 4.创建数据库执行对象（通过连接对象创建）
            Statement sta = con.createStatement();
            // 5.定义sql语句
            String sql = "select * from subject";
            // 6.数据库执行对象执行sql语句，并返回结果集对象
            ResultSet set = sta.executeQuery(sql);
            // 7.结果集对象，读取返回的数据
            // next一下表示读取一行，有数据返回true，没有数据返回false
            while(set.next()){
                // 通过列名 或 列的位置 读取每一列数据
                // 通过getXXX方法读取具体的列，比如：getInt方法会将读取的数据转为int返回
                /*System.out.println(set.getInt(1)+" "+set.getString(2)+" "+
                        set.getInt(3)+" "+set.getInt(4));*/
                /*System.out.println(set.getInt("subjectId")+" "+
                        set.getString("subjectName")+" "+
                        set.getInt("classHour")+" "+
                        set.getInt("gradeId"));*/
                // 使用getObject方法，将读取的所有列转为object类型返回
                System.out.println(set.getObject("subjectId")+" "+
                        set.getObject("subjectName")+" "+
                        set.getObject("classHour")+" "+
                        set.getObject("gradeId"));
            }
            // 8.关闭数据库资源
            sta.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
