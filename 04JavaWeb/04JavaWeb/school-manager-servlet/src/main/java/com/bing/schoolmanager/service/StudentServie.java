package com.bing.schoolmanager.service;

import com.bing.schoolmanager.pojo.Student;

import java.util.List;

public interface StudentServie {
    List<Student> getStudentsByName(String studentName);
}
