package com.bing;

import com.bing.pojo.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 创建一个学生集合
        List<Student> stus = new ArrayList<>();
        Student student1 = new Student();
        student1.setNo(1);
        student1.setName("易烊千玺");
        student1.setHobby("演戏");
        stus.add(student1);

        Student student2 = new Student();
        student2.setNo(2);
        student2.setName("王俊凯");
        student2.setHobby("唱歌");
        stus.add(student2);

        Student student3 = new Student();
        student3.setNo(3);
        student3.setName("王源");
        student3.setHobby("抽烟");
        stus.add(student3);
        // 返回集合的长度
        System.out.println(stus.size());
        stus.forEach(s->{
            System.out.println(s);
        });
    }
}
