package com.bing.schoolmanager.service.impl;

import com.bing.schoolmanager.mapper.GradeMapper;
import com.bing.schoolmanager.mapper.StudentMapper;
import com.bing.schoolmanager.pojo.Grade;
import com.bing.schoolmanager.pojo.Student;
import com.bing.schoolmanager.service.StudentServie;
import com.bing.schoolmanager.util.MybatisUtil;

import java.util.List;

public class StudentServiceImpl implements StudentServie {
    StudentMapper studentMapper = MybatisUtil.getSession(true)
            .getMapper(StudentMapper.class);
    GradeMapper gradeMapper = MybatisUtil.getSession(true)
            .getMapper(GradeMapper.class);
    @Override
    public List<Student> getStudentsByName(String studentName) {
        List<Student> students = studentMapper.getStudentsByName(studentName);
        List<Grade> grades = gradeMapper.getAllGrade();
        students.forEach(s->{
            Grade grade = grades.stream().filter(g -> g.getGradeId() == s.getGradeId()).findFirst().get();
            s.setGrade(grade);
        });
        return students;
    }
}
