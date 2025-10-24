package com.bing.test;

import com.bing.mapper.SubjectMapper;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.List;

// 动态SQL - foreach：批量删除
public class Test16 {
    public static void main(String[] args) {
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
            // 这里可以将一个数组转为集合
            // JDK9之后可以这样写 List.of(17,18,19,20,21,22);
            List<Integer> subjectIds = Arrays.asList(17,18,19,20,21,22);
            int rows = subjectMapper.deleteSubjects(subjectIds);
            System.out.println(rows);
        }
    }
}
