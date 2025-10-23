package com.bing.project4.test;

import com.bing.project4.mapper.SubjectMapper;
import com.bing.project4.pojo.Subject;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


// 添加
public class Test2 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            int rows = subjectMapper.addSubject(
                    new Subject()
                            .setSubjectName("勇敢的心")
                            .setClassHour(111)
                            .setGradeId(1)
            );
            System.out.println(rows);
        }
    }
}
