package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 删除课程
public class Test12 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            int rows = subjectMapper.deleteSubject(14);
            System.out.println(rows);
        }
    }
}
