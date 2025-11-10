package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        // 创建容器
        ApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        // 直接从容器中拿到具体的Mapper对象
        // 这种方式的前提条件是容器中首先必须要有'sqlSessionFactory' 或者 'sqlSessionTemplate'对象
        // 因为context.getBean(SubjectMapper.class)返回的对象，
        // 背后还有sqlSessionTemplate.getMapper(SubjectMapper.class)返回的
        SubjectMapper subjectMapper = context.getBean(SubjectMapper.class);
        Subject subject = subjectMapper.getSubjectById(1);
        System.out.println(subject);

    }
}
