package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

// 事务操作
// 当我们一个业务要执行多条操作语句的时候，通常会开启事务模式
// 要么全部执行，要么全部撤销，比如：转账业务
public class Test13 {
    public static void main(String[] args) {
        // 这里关闭自动事务提交
        try(SqlSession sqlSession = MybatisUtil.getSession(false)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            Subject subject1 = new Subject()
                    .setSubjectName("课程1").setClassHour(123).setGradeId(1);
            Subject subject2 = new Subject()
                    .setSubjectName("课程2").setClassHour(123).setGradeId(1);
            subjectMapper.addSubject(subject1);
            subjectMapper.addSubject(subject2);
            // 必须要手动提交事务，才会更新数据库
            sqlSession.commit();    //提交事务
            //sqlSession.rollback();  //回滚事务
        }
    }
}
