package com.bing.test06;

import java.sql.*;
import java.util.Scanner;

public class LoginTest2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入账号：");
        String loginId = input.nextLine();
        System.out.print("请输入密码：");
        String loginPwd = input.nextLine();
        try(
                //连接对象
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/myschool","root","root1234");
                //执行对象
                //通过案例1我们发现，Statement执行的SQL语句存在严重的SQL注入攻击漏洞
                //改成PreparedStatement
                //Statement statement = connection.createStatement();
                //在创建PreparedStatement的时候，需要先将sql语句传入
                //如果sql语句需要拼接参数，使用?定义占位符
                PreparedStatement statement = connection.prepareStatement(
                        "select count(*) from admin where loginId=? and loginPwd=?");
        ){
            //设置执行对象中sql语句的参数
            statement.setString(1,loginId);
            statement.setString(2,loginPwd);
            //注意：这里执行时就不需要传入sql语句了，因为在创建执行对象时已经传入了sql语句
            ResultSet set = statement.executeQuery();
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
    }
}
