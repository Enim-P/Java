package com.bing.mapper;

import com.bing.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAllStudnet();

    @Select("select * from student where studentNo=#{no}")
    Student getOneStudent(String no);

    @Insert("insert into student values(#{studentNo},#{loginPwd},#{studentName}" +
            ",#{sex},#{gradeId},#{phone},#{address},#{bornDate},#{email},#{identityCard})")
    int addStudent(Student student);

    @Update("update student set loginPwd=#{loginPwd},studentName=#{studentName}," +
            "sex=#{sex},gradeId=#{gradeId},phone=#{phone},address=#{address}," +
            "bornDate=#{bornDate},email=#{email},identityCard=#{identityCard}" +
            "where studentNo=#{studentNo}")
    int updateStudent(Student student);

    @Delete("delete from student where studentNo=#{no}")
    int deleteStudent(String no);

}
