package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

// 根据指定的年级+课程名称查询
public class Test9 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Subject> subjects = subjectMapper.selectSubjectsByGradeIdAndName(2, "系统");
            System.out.println(subjects);
        }
    }
}
