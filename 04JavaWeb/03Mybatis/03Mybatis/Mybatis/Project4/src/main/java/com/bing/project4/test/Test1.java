package com.bing.project4.test;

import com.bing.project4.mapper.SubjectMapper;
import com.bing.project4.pojo.Subject;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 使用注解开发
public class Test1 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Subject> subjects = subjectMapper.selectAllSubject();
            subjects.forEach(System.out::println);
        }
    }
}
