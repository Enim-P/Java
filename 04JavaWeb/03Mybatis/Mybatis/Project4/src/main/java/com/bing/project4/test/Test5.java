package com.bing.project4.test;

import com.bing.project4.mapper.SubjectMapper;
import com.bing.project4.pojo.Subject;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 修改方法传递多个参数的方式
public class Test5 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject = new Subject()
                    .setSubjectName("激战")
                    .setClassHour(111)
                    .setGradeId(1);
            int rows = subjectMapper.updateSubject2(29,subject);
            System.out.println(rows);
        }
    }
}
