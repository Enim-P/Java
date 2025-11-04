package com.bing.schoolmanager.mapper;

import com.bing.schoolmanager.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student where studentName like concat('%',#{studentName},'%')")
    List<Student> getStudentsByName(String studentName);
}
