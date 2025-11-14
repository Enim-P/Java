package com.bing.service.impl;

import com.bing.mapper.StudentMapper;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> getAllStudnet() {
        return studentMapper.getAllStudnet();
    }

    @Override
    public Student getOneStudent(String no) {
        return studentMapper.getOneStudent(no);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(String no) {
        return studentMapper.deleteStudent(no);
    }
}
