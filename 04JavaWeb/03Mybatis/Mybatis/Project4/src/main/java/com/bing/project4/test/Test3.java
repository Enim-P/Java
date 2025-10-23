package com.bing.project4.test;

import com.bing.project4.mapper.SubjectMapper;
import com.bing.project4.pojo.Subject;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 修改
public class Test3 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject = new Subject()
                    .setSubjectId(30)
                    .setSubjectName("寒战")
                    .setClassHour(222)
                    .setGradeId(2);
            int rows = subjectMapper.updateSubject(subject);
            System.out.println(rows);
        }
    }
}
