package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 添加课程
public class Test10 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject = new Subject().setSubjectName("ABC").setClassHour(123).setGradeId(1);
            int rows = subjectMapper.addSubject(subject);
            System.out.println(rows);
        }
    }
}
