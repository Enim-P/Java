package com.bing.dao;

import java.sql.*;

/**
 * 数据访问层基类：数据库操作的通用类
 */
public class BaseDao_bak {
    /**
     * 数据库连接对象
     */
    protected Connection conn;
    /**
     * 数据库执行对象
     */
    protected PreparedStatement ps;
    /**
     * 结果集对象
     */
    protected ResultSet rs;

    /**
     * 获取数据库连接
     * @return 连接成功返回true
     */
    public boolean getConnection(){
        //定义数据库配置信息
        //连接驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //连接地址
        String url = "jdbc:mysql://localhost:3306/myschool";
        //登录名
        String username = "root";
        //登录密码
        String password = "root1234";
        try{
            // 加载JDBC驱动
            Class.forName(driver);
            // 返回数据库连接对象
            conn = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 增删改方法
     * @param sql 执行增删改的sql语句
     * @param params 参数数组
     * @return 返回受影响的行数
     */
    public int executeUpdate(String sql,Object... params){
        int updateRows = 0;  //受影响行数
        if(getConnection()){
            try {
                // 在创建PreparedStatement对象时，需要传递sql语句
                ps = conn.prepareStatement(sql);
                if(params!=null){
                    // 填充sql语句中的参数
                    for(int i=0;i<params.length;i++){
                        ps.setObject(i+1,params[i]);
                    }
                }
                // 执行sql语句，返回受影响行数
                updateRows = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 关闭资源
                this.closeResource();
            }
        }
        return updateRows;
    }

    /**
     * 查询方法
     * @param sql 执行查询的sql语句
     * @param params 参数数组
     * @return 返回结果集对象
     */
    public ResultSet executeQuery(String sql,Object... params){
        if(getConnection()){
            try {
                // 在创建PreparedStatement对象传递sql语句
                ps = conn.prepareStatement(sql);
                if(params!=null){
                    // 填充sql语句中的参数
                    for(int i=0;i<params.length;i++){
                        ps.setObject(i+1,params[i]);
                    }
                }
                // 执行sql语句，返回结果集对象
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 返回全局定义的结果集对象
        return rs;
    }

    /**
     * 关闭资源的方法
     */
    public void closeResource(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
