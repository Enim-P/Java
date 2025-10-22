package com.bing.test;

import com.bing.mapper.GradeMapper;
import com.bing.pojo.Grade;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 一对多关系：需要自定义映射
public class Test6 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
            List<Grade> grades = gradeMapper.selectAllGrade();
            grades.forEach(g->{
                System.out.println(g);
            });
        }
    }
}
