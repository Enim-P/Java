package com.bing.test06;

import java.sql.*;
import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入账号：");
        String loginId = input.nextLine();
        System.out.print("请输入密码：");
        String loginPwd = input.nextLine();
        // 组织登录sql语句
        String sql = String.format("select count(*) from admin where loginId='%s' and loginPwd='%s'",
                loginId,loginPwd);
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                Statement statement = connection.createStatement();
        ){
            //执行sql语句，返回结果集对象
            ResultSet set = statement.executeQuery(sql);
            //因为这里最多返回一条数据，所以用if读取一行就可以了
            if(set.next()){
                int count = set.getInt(1);
                if(count>=1){
                    System.out.println("登录成功！");
                }else{
                    System.out.println("登录失败！");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 登录名随便输入，密码也是随便输入，但是密码必须以' or 1=1; -- 结尾
        // 此时就破解了当前项目的登录入口
        // 所以，我们之前的写法是存在安全隐患的
    }
}
