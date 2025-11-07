package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.pojo.Student;
import com.bing.pojo.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        // 根据bean的名称获取bean对象
        //Student student = (Student) context.getBean("student");
        // 根据类型获取bean对象
        Student student1 = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);
        //spring管理的bean默认采用单例模式创建
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1==student2);
        System.out.println("-----------------------");
        Teacher teacher1 = context.getBean(Teacher.class);
        Teacher teacher2 = context.getBean(Teacher.class);
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(teacher1==teacher2);
    }
}
