package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 开启二级缓存
public class Test3 {
    public static void main(String[] args) {
        // 这里是两个独立的SqlSession对象，所以彼此的缓存是无法通用的
        Subject subject1;
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subject1 = subjectMapper.selectOneSubject(1);
        }

        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject2 = subjectMapper.selectOneSubject(1);
            System.out.println(subject1);
            System.out.println(subject2);
            System.out.println(subject1==subject2);
        }
        System.out.println("--------------------------------");
        // selectOneSubject2方法关闭了二级缓存，所以是false
        Subject subject3;
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            subject3 = subjectMapper.selectOneSubject2(1);
        }

        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject4 = subjectMapper.selectOneSubject2(1);
            System.out.println(subject3);
            System.out.println(subject4);
            System.out.println(subject3==subject4);
        }
    }
}
