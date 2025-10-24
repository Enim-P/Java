package com.bing.project4.test;

import com.bing.project4.mapper.GradeMapper;
import com.bing.project4.pojo.Grade;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 一对多映射关系
public class Test7 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
            Grade grade = gradeMapper.selectGradeById(1);
            System.out.println(grade);
        }
    }
}
