package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 动态SQL - where
public class Test18 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 全查
            List<Subject> subjects1 = subjectMapper.selectSubjectsByCondition(null,null);
            System.out.println(subjects1);
            // 根据年级查询
            List<Subject> subjects2 = subjectMapper.selectSubjectsByCondition(2,null);
            System.out.println(subjects2);
            // 根据课程名称查询
            List<Subject> subjects3 = subjectMapper.selectSubjectsByCondition(null,"系统");
            System.out.println(subjects3);
            // 同时根据年级和课程名称查查询
            List<Subject> subjects4 = subjectMapper.selectSubjectsByCondition(2,"系统");
            System.out.println(subjects4);
        }
    }
}
