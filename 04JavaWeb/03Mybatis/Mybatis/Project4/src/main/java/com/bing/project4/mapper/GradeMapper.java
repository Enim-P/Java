package com.bing.project4.mapper;

import com.bing.project4.pojo.Grade;
import com.bing.project4.pojo.Subject;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeMapper {

    // 映射一对多关系
    @Results({
            /*@Result(id = true,column = "gradeId",property = "gradeId"),
            @Result(column = "gradeName",property = "gradeName"),*/
            @Result(column = "gradeId",property = "subjectList",
                    // 调用根据年级编号查询课程的方法
                    many = @Many(select = "getSubjectsByGradeId")
            )
    })
    @Select("select * from grade where gradeId=#{gradeId}")
    Grade selectGradeById(int gradeId);

    @Select("select * from subject where gradeId=#{gradeId}")
    List<Subject> getSubjectsByGradeId(int gradeId);
}
