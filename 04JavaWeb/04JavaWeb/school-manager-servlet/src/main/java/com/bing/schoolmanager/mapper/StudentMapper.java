package com.bing.schoolmanager.mapper;

import com.bing.schoolmanager.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student where studentName like concat('%',#{studentName},'%')")
    List<Student> getStudentsByName(String studentName);

    @Insert("insert into student(studentNo,loginPwd,studentName,sex,gradeId," +
            "phone,address,bornDate,email,identityCard) " +
            "values(#{studentNo},#{loginPwd},#{studentName},#{sex},#{gradeId}," +
            "#{phone},#{address},#{bornDate},#{email},#{identityCard})")
    int addStudent(Student student);

    @Delete("delete from student where studentNo=#{studentNo}")
    int deleteStudent(String studentNo);
}
