package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 一对一关系：自定义映射
public class Test7 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Subject> subjects = subjectMapper.selectAllSubject4();
            subjects.forEach(System.out::println);
        }
    }
}
