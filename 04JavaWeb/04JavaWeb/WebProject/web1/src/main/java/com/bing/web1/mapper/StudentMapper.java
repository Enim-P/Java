package com.bing.web1.mapper;

import com.bing.web1.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    //查询学生列表
    @Select("select * from student where studentName like concat('%',#{studentName},'%')")
    List<Student> studentList(String studentName);

    //添加学生
    @Insert("insert into student values(#{studentNo},#{loginPwd},#{studentName},#{sex},#{gradeId},#{phone},#{address},#{bornDate},#{email},#{identityCard})")
    int addStudent(Student student);

    //删除学生
    @Delete("delete from student where studentNo=#{studentNo}")
    int delStudent(String studentNo);
}
