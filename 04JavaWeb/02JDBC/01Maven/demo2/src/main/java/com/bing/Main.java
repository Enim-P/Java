package com.bing;

import com.bing.pojo.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNo(1);
        student.setName("周杰伦");
        student.setHobby("唱歌");
        System.out.println(student);
    }
}