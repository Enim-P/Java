package com.bing.mapper;

import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubjectMapper {

    //根据课程编号查询课程
    @Select("select * from subject where subjectId=#{id}")
    Subject getSubjectById(Integer id);

    //查询所有课程
    @Select("select * from subject")
    List<Subject> getSubjects();

    //添加课程
    @Insert("insert into subject(subjectName,classHour,gradeId) " +
            "values(#{subjectName},#{classHour},#{gradeId})")
    int addSubject(Subject subject);

    //修改课程
    @Update("update subject set subjectName=#{subjectName}," +
            "classHour=#{classHour},gradeId=#{gradeId} where subjectId=#{subjectId}")
    int updateSubject(Subject subject);

    //删除课程
    @Delete("delete from subject where subjectId=#{id}")
    int deleteSubject(Integer id);
}
