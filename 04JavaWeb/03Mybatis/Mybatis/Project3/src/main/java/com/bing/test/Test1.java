package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// Mybatis默认会开启一级缓存，并且无法关闭
// 一级缓存将SqlSession的整个生命周期进行缓存
public class Test1 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 这里是第一次查询数据，根据课程编号1查询
            Subject subject1 = subjectMapper.selectOneSubject(1);
            // 第二个再根据课程编号1查询的时候，没有走数据库，而是直接走缓存
            Subject subject2 = subjectMapper.selectOneSubject(1);

            // 注意：这里创建了两个SqlSession
            // 第一个SqlSeesion产生的缓存，第二个SqlSession是无使用的
            try(SqlSession sqlSession2 = MybatisUtil.getSession(true)){
                SubjectMapper subjectMapper2 = sqlSession2.getMapper(SubjectMapper.class);
                // 这里是第一次查询数据，根据课程编号1查询
                Subject subject3 = subjectMapper2.selectOneSubject(1);
                System.out.println(subject3);
                System.out.println(subject3==subject1);
            }

            // 发现两个对象的地址完全一样
            System.out.println(subject1);
            System.out.println(subject2);
            System.out.println(subject1==subject2);
        }

    }
}
