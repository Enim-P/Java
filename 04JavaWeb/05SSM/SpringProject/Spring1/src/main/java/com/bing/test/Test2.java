package com.bing.test;

import com.bing.pojo.Student;
import com.bing.pojo.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 从容器中获取两次学生对象
        // 注意：默认它采用的是单例模式创建对象，如果拿的是同一个bean对象，只会new一次
        // 而且是在容器初始化的时候，就将当前容器管理的所有bean提前创建
        Student student1 = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1==student2);
        System.out.println("--------------------------------");
        // 采用原型模式定义的bean，只会在调用的时候才会创建成对象，而且是调用一次创建一次
        Teacher teacher1 = (Teacher) context.getBean("teacher");
        Teacher teacher2 = (Teacher) context.getBean("teacher");
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(teacher1==teacher2);
    }
}
