package com.bing.mapper;

import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 课程数据访问层Mapper
 */
@Mapper  // mybatis会帮我们创建一个代理对象，来实现该接口的功能
public interface SubjectMapper {
    // 插入成功后，获取插入到数据表中的主键值
    @Options(keyProperty = "subjectId",useGeneratedKeys = true)
    @Insert("insert into subject(subjectName,classHour,gradeId)" +
            " values(#{subjectName},#{classHour},#{gradeId})")
    int insertSubject(Subject subject);

    @Select("select * from subject")
    List<Subject> selectAll();

    // 当查询的列名跟实体类的字段名不同时，需要手动映射它们的关系
    @Results({
            // column：指定数据表中的列名
            // property：指定实体类中的字段名
            @Result(column = "id",property = "subjectId"),
            @Result(column = "name",property = "subjectName")
    })
    @Select("select subjectId as id,subjectName as name,classHour,gradeId from subject")
    List<Subject> selectAll2();

}
