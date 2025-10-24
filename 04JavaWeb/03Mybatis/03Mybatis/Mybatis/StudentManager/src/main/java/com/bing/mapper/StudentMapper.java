package com.bing.mapper;

import com.bing.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生Mapper
 */
public interface StudentMapper {
    // 添加学生
    int insertStudent(Student student);
    // 修改学生
    int updateStudent(Student student);
    // 删除学生
    int deleteStudent(String studentNo);
    // 根据学号查询学生
    Student selectStudentByNo(String studentNo);
    // 查询全部学生
    List<Student> selectAll();
    // 根据年级查询学生
    List<Student> selectByGrade(int gradeId);
    // 根据姓名查询学生
    List<Student> selectByName(String studentName);
    // 根据年级和姓名查询学生
    List<Student> selectByGradeAndName(@Param("gradeId") Integer gradeId, @Param("studentName") String studentName);
}
