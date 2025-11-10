package com.bing.test;

import com.bing.config.NoXmlConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 从控制台输入一个课程信息，然后添加到数据库中
        System.out.print("请输入课程名称：");
        String subjectName = input.next();
        System.out.print("请输入课程课时：");
        Integer classHour = input.nextInt();
        System.out.print("请输入课程年级：");
        Integer gradeId = input.nextInt();
        // 创建一个课程对象
        Subject subject = new Subject();
        subject.setSubjectName(subjectName);
        subject.setClassHour(classHour);
        subject.setGradeId(gradeId);
        ApplicationContext context = new AnnotationConfigApplicationContext(
                NoXmlConfiguration.class
        );
        SubjectMapper subjectMapper = context.getBean(SubjectMapper.class);
        int rows = subjectMapper.addSubject(subject);
        System.out.println(rows);
    }
}
