package com.bing.service.impl;

import com.bing.dao.IGradeDao;
import com.bing.dao.IStudentDao;
import com.bing.dao.impl.GradeDao;
import com.bing.dao.impl.StudentDao;
import com.bing.pojo.Grade;
import com.bing.pojo.Student;
import com.bing.service.IStudentService;

import java.util.List;

/**
 * 学生业务逻辑类
 */
public class StudentService implements IStudentService {
    // 创建学生数据访问层对象
    IStudentDao studentDao = new StudentDao();
    // 创建年级数据访问层对象
    IGradeDao gradeDao = new GradeDao();

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(String studentNo) {
        return studentDao.deleteStudent(studentNo);
    }

    @Override
    public Student selectStudentByNo(String studentNo) {
        // 查询返回学生对象
        Student student = studentDao.selectStudentByNo(studentNo);
        if(student==null){
            return null;
        }
        // 查询当前学生对应的年级信息
        Grade grade = gradeDao.selectOne(student.getGradeId());
        // 设置学生的年级信息
        student.setGrade(grade);
        return student;
    }

    @Override
    public List<Student> selectAll() {
        // 业务逻辑层如果没有业务要处理，就直接将数据访问层的结果返回
        List<Student> students = studentDao.selectAll();
        StudentAddGrade(students);
        return students;
    }

    @Override
    public List<Student> selectByGrade(int gradeId) {
        List<Student> students = studentDao.selectByGrade(gradeId);
        StudentAddGrade(students);
        return students;
    }

    @Override
    public List<Student> selectByName(String studentName) {
        List<Student> students = studentDao.selectByName(studentName);
        StudentAddGrade(students);
        return students;
    }

    @Override
    public List<Student> selectByGradeAndName(int gradeId, String studentName) {
        List<Student> students = studentDao.selectByGradeAndName(gradeId,studentName);
        StudentAddGrade(students);
        return students;
    }

    // 给学生添加年级属性
    public void StudentAddGrade(List<Student> students){
        List<Grade> grades = gradeDao.selectAll();
        // 遍历学生集合，给每个学生对象添加年级对象
        students.forEach(s->{
            Grade grade = grades.stream().filter(g->g.getGradeId()==s.getGradeId())
                    .findFirst().get();
            s.setGrade(grade);
        });
    }
}
