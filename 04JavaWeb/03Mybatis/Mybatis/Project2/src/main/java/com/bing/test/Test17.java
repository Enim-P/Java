package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.List;

// 动态SQL - foreach：批量插入
public class Test17 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Subject> subjects = Arrays.asList(
                    new Subject()
                            .setSubjectName("课程1").setClassHour(111).setGradeId(1),
                    new Subject()
                            .setSubjectName("课程2").setClassHour(222).setGradeId(2)
            );
            int rows = subjectMapper.addSubjects(subjects);
            System.out.println(rows);
        }
    }
}
