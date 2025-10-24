package com.bing.test;

import com.bing.mapper.StudentMapper;
import com.bing.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

public class Test2 {
    // SqlSession工厂
    private SqlSessionFactory sqlSessionFactory;
    // @Before注解的方法在测试方法之前执行
    @Before
    public void before(){
        System.out.println("测试前置方法....");
        // 初始化SqlSession工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Test2.class.getClassLoader().getResourceAsStream("mybatis-config.xml")
        );

        // 初始化日志管理器
        LogManager manager = LogManager.getLogManager();
        try {
            manager.readConfiguration(
                    Test2.class.getClassLoader().getResourceAsStream("Logging.properties")
            );
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    @After
    public void after(){
        System.out.println("测试后置方法....");
    }

    // 测试查询全部学生信息是否正常
    @Test
    public void method1(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectAll();
            System.out.println(students);
        }
    }

    // 测试查询指定年级学生信息是否正常
    @Test
    public void method2(){
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByGrade(2);
            System.out.println(students);
        }
    }
}
