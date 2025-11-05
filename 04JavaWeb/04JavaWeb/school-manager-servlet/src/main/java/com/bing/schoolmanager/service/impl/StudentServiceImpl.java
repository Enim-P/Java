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
        for(Student s : students){
            Grade grade = gradeMapper.getGradeById(s.getGradeId());
            s.setGrade(new Grade(grade.getGradeId(),grade.getGradeName()));
        }
        return students;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int deleteStudent(String studentNo) {
        return studentMapper.deleteStudent(studentNo);
    }
}
