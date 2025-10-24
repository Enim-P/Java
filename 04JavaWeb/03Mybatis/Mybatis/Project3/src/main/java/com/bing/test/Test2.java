package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class Test2 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 根据课程编号1查询课程，查询结果会被缓存起来
            Subject subject1 = subjectMapper.selectOneSubject(1);
            // 执行插入操作（对数据库执行DML操作），之前的缓存全部失效
            subjectMapper.addSubject(
                    new Subject().setSubjectName("哈哈")
                            .setClassHour(22)
                            .setGradeId(2)
            );
            // 再根据课程编号1查询课程
            Subject subject2 = subjectMapper.selectOneSubject(1);

            System.out.println(subject1);
            System.out.println(subject2);
            System.out.println(subject1==subject2);
        }
    }
}
