package com.bing.schoolmanager.mapper;

import com.bing.schoolmanager.pojo.Grade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeMapper {
    @Select("select * from grade where gradeId=#{gradeId}")
    Grade getGradeById(int gradeId);

    @Select("select * from grade")
    List<Grade> getAllGrade();
}
