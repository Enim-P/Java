package com.bing.test;

import com.bing.config.NoXmlConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j   // Lombok为Slf4j日志框架推出注解
public class Test3 {
    public static void main(String[] args) {
        // 普通打印只是纯打印
        System.out.println("项目正在启动...");
        // 打印输出日志信息（日志的输出信息中包含时间和地点信息）
        log.info("项目正在启动...");

        // 拿到容器
        ApplicationContext context = new AnnotationConfigApplicationContext(
                NoXmlConfiguration.class
        );
        // 从容器中拿到具体的Mapper对象
        SubjectMapper subjectMapper = context.getBean(SubjectMapper.class);
        Subject subject = subjectMapper.getSubjectById(1);
        System.out.println(subject);
    }
}
