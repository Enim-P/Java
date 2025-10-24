package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            while (true){
                Thread.sleep(5000);
                Subject subject = subjectMapper.selectOneSubject(1);
                System.out.println(subject.getSubjectName());
            }
        }
    }
}
