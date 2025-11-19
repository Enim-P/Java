package com.bing;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SubjectTest {
    @Resource
    SubjectMapper subjectMapper;

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

    @Test
    void testSelectAll(){
        List<Subject> subjects = subjectMapper.selectAll();
        System.out.println(subjects);
    }

    @Test
    void testSelectAll2(){
        List<Subject> subjects = subjectMapper.selectAll2();
        System.out.println(subjects);
    }
}
