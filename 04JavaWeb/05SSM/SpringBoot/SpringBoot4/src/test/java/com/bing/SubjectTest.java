package com.bing;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SubjectTest {
    @Resource
    SubjectMapper subjectMapper;

    // 插入
    @Test
    void testInsert(){
        Subject subject = new Subject();
        subject.setSubjectName("课程B");
        subject.setClassHour(100);
        subject.setGradeId(1);
        int rows = subjectMapper.insertSubject(subject);
        System.out.println(rows);
        System.out.println(subject);
    }

    // 查询全部
    @Test
    void testSelectAll(){
        List<Subject> subjects = subjectMapper.selectAll();
        System.out.println(subjects);
    }

    // 查询全部（列名跟实体类字段名不同）
    @Test
    void testSelectAll2(){
        List<Subject> subjects = subjectMapper.selectAll2();
        System.out.println(subjects);
    }

    // 根据条件查询课程
    @Test
    void testSelectCondition(){
        String subjectName = "java";
        Integer classHour1 = 20;
        Integer classHour2 = 60;
//        List<Subject> subjects = subjectMapper.selectCondition(subjectName, classHour1, classHour2);
//        List<Subject> subjects = subjectMapper.selectCondition(null, null, null);
//        List<Subject> subjects = subjectMapper.selectCondition(subjectName, null,null);
//        List<Subject> subjects = subjectMapper.selectCondition(null, classHour1,null);
//        List<Subject> subjects = subjectMapper.selectCondition(null, null,classHour2);
//        List<Subject> subjects = subjectMapper.selectCondition(subjectName, classHour1,null);
        List<Subject> subjects = subjectMapper.selectCondition(subjectName, null,classHour2);
//        List<Subject> subjects = subjectMapper.selectCondition(null, classHour1,classHour2);

        System.out.println(subjects);
    }

    // 测试批量删除课程信息
    @Test
    void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(13,14,15);
        int rows = subjectMapper.deleteByIds(ids);
        System.out.println(rows);
    }
}
