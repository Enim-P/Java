package com.bing.dao;

import com.bing.pojo.Student;

import java.util.List;

/**
 * 学生数据访问层接口
 */
public interface IStudentDao {
    // 添加学生
    int insertStudent(Student student);
    // 修改学生
    int updateStudent(Student student);
    // 删除学生
    int deleteStudent(String studentNo);
    // 查询全部学生
    List<Student> selectAll();
    // 根据年级查询学生
    List<Student> selectByGrade(int gradeId);
    // 根据姓名查询学生
    List<Student> selectByName(String studentName);
    // 根据年级和姓名查询学生
    List<Student> selectByGradeAndName(int gradeId,String studentName);
}
