package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Kc;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            List<Kc> keChengs = subjectMapper.selectAllSubject3();
            System.out.println(keChengs);
        }
    }
}
