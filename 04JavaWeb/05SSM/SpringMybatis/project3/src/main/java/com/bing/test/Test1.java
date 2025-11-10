package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        SubjectMapper subjectMapper = context.getBean(SubjectMapper.class);
        List<Subject> subjects = subjectMapper.getSubjects();
        subjects.forEach(System.out::println);
    }
}
