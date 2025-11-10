package com.bing.test;

import com.bing.config.DBConfiguration;
import com.bing.config.MainConfiguration;
import com.bing.pojo.Student;
import com.bing.util.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class Test1 {
    public static void main(String[] args) {
        // 创建注解配置的Spring容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Student student = context.getBean(Student.class);
        System.out.println(student);
        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);

        /*AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(
                DBConfiguration.class
        );
        Connection connection = context2.getBean(Connection.class);*/
        Connection connection = context.getBean(Connection.class);
        System.out.println(connection);
    }
}
