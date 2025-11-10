package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        // 创建容器
        ApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        // 拿到数据会话模版对象（就是之前的数据会话工厂）
        SqlSessionTemplate template = context.getBean(SqlSessionTemplate.class);
        // 通过数据会话模版对象拿到对应的Mapper对象
        SubjectMapper subjectMapper = template.getMapper(SubjectMapper.class);
        // 最后再有具体的Mapper对象对数据表进行实际的操作
        Subject subject = subjectMapper.getSubjectById(1);
        System.out.println(subject);

    }
}
