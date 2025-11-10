package com.bing.mapper;

import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubjectMapper {

    @Select("select * from subject where subjectId=#{id}")
    Subject getSubjectById(Integer id);

    @Insert("insert into subject(subjectName,classHour,gradeId) " +
            "values(#{subjectName},#{classHour},#{gradeId})")
    int addSubject(Subject subject);
}
