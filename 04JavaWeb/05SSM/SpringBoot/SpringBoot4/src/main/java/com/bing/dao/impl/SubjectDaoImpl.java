package com.bing.dao.impl;

import com.bing.dao.BaseDao;
import com.bing.dao.SubjectDao;
import com.bing.pojo.Subject;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程数据访问层实现类
 */
@Repository   // 数据访问类
public class SubjectDaoImpl extends BaseDao implements SubjectDao {
    // 最原始的写法
    /*
    @Override
    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<>();
        try{
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取链接
            String url = "jdbc:mysql://localhost:3306/myschool";
            String username = "root";
            String password = "root1234";
            Connection conn = DriverManager.getConnection(url,username,password);
            //3.获取数据库执行对象
            Statement statement = conn.createStatement();
            String sql = "select * from subject";
            //4.执行sql语句，返回结果集对象
            ResultSet resultSet = statement.executeQuery(sql);
            //5.结果集对象逐行读取查询的结果，并将结果添加到对应的集合中保存
            while (resultSet.next()){
                Integer subjectId = resultSet.getInt("subjectId");
                String subjectName = resultSet.getString("subjectName");
                Integer classHour = resultSet.getInt("classHour");
                Integer gradeId = resultSet.getInt("gradeId");
                Subject subject = new Subject(subjectId,subjectName,classHour,gradeId);
                subjects.add(subject);
            }
            //6.释放资源
            resultSet.close();
            statement.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException  e){
            e.printStackTrace();
        }
        //7.返回结果
        return subjects;
    }
    */

    // 封装一个BaseDao出去的写法
    @Override
    public List<Subject> selectAll() {
        List<Subject> subjects = new ArrayList<>();
        try{
            String sql = "select * from subject";
            ResultSet resultSet = executeQuery(sql);
            while (resultSet.next()){
                Integer subjectId = resultSet.getInt("subjectId");
                String subjectName = resultSet.getString("subjectName");
                Integer classHour = resultSet.getInt("classHour");
                Integer gradeId = resultSet.getInt("gradeId");
                Subject subject = new Subject(subjectId,subjectName,classHour,gradeId);
                subjects.add(subject);
            }
        }catch (SQLException  e){
            e.printStackTrace();
        }finally {
            closeResource();
        }
        return subjects;
    }
}
