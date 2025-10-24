package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 修改课程
public class Test11 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject = new Subject().setSubjectId(13)
                    .setSubjectName("CBA").setClassHour(321).setGradeId(2);
            int rows = subjectMapper.updateSubject(subject);
            System.out.println(rows);
        }
    }
}
