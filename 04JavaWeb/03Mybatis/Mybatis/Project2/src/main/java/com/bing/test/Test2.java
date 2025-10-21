package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

// 直接操作Mapper接口返回结果
public class Test2 {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // 返回对应的Mapper接口对象
            // 这里通过sqlSession的getMapper方法，通过发射创建一个对应的实现类
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 它是一个动态代理类对象
            // System.out.println(subjectMapper);
            List<Subject> subjects = subjectMapper.selectAllSubject();
            subjects.forEach(System.out::println);
        }
    }
}
