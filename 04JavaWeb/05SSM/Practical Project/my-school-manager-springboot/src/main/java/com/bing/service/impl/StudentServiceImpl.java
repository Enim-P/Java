package com.bing.service.impl;

import com.bing.mapper.GradeMapper;
import com.bing.mapper.StudentMapper;
import com.bing.pojo.Grade;
import com.bing.pojo.PageBean;
import com.bing.pojo.Student;
import com.bing.pojo.Subject;
import com.bing.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生Service实现类
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    GradeMapper gradeMapper;

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int delete(String studentNo) {
        return studentMapper.delete(studentNo);
    }

    @Override
    public Student findByNo(String studentNo) {
        Student student = studentMapper.findByNo(studentNo);
        if(student!=null){
            Grade grade = gradeMapper.findById(student.getGradeId());
            student.setGrade(grade);
        }
        return student;
    }

    @Override
    public PageBean<Student> findByCondition(Integer gradeId,
                                      String studentName,
                                      Integer pageIndex,
                                      Integer pageSize) {
        //开启分页功能
        PageHelper.startPage(pageIndex,pageSize);
        //根据条件查询学生信息
        List<Student> students = studentMapper.findByCondition(gradeId, studentName);
        //给每个学生添加年级信息
        students.forEach(s->{
            Grade grade = gradeMapper.findById(s.getGradeId());
            s.setGrade(grade);
        });
        //将查询结果转为分页数据
        Page<Student> pages = (Page<Student>) students;
        PageBean<Student> pageBean = new PageBean<>(pages.getTotal(),pages.getResult());
        return pageBean;
    }
}
