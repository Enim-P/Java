package com.bing.web1.mapper;

import com.bing.web1.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    // 查询学生列表
    @Select("select * from student where studentName like concat('%',#{studentName},'%')")
    List<Student> studentList(String studentName);
}
