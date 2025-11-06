package com.bing.test;

import com.bing.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        // AOP 的全程（完整英文名称）是 Aspect-Oriented Programming，中文译为 面向切面编程。
        // 面向切面编程：对现有功能进行扩展的编程方式。
        // 当我们无法直接对原始方法做更改时，就只能使用AOP的方式对原始方法进行增强
        /*
            比如：现在有一个方法可以实现加法运算，但是该方法在进行计算之前并没有做验证，
            同时该方法在技术结果后并没有记录日志，当时方法已经写好了，甚至可能都已经打成jar包了，
            这个时候我们要对该方法进行增强，这就是AOP编程，面向切面编程。
        */

        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 拿到Student对象
        Student student = context.getBean(Student.class);
        int len = student.strLength("Hello World");
        System.out.println(len);
    }
}
