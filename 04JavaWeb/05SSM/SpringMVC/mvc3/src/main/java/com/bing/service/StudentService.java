package com.bing.service;

import com.bing.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudnet();
    Student getOneStudent(String no);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(String no);
}
