package com.bing.project4.test;

import com.bing.project4.mapper.SubjectMapper;
import com.bing.project4.pojo.Subject;
import com.bing.project4.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 调用查询全部课程信息的第三个方法
            List<Subject> subjects = subjectMapper.selectAllSubject3();
            subjects.forEach(System.out::println);
        }
    }
}
