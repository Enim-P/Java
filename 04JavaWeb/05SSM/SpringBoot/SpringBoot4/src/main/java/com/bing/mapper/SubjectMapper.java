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

    // 根据条件查询课程
    // 如果传课程名称，根据课程名称模糊查询
    // 如果同时传了classHour1 和 classHour2 查询课时在该区间的课程
    // 如果只传classHour1 查询课时大于classHour1的课程
    // 如果只传classHour2 查询课时小于classHour2的课程
    List<Subject> selectCondition(
            @Param("subjectName") String subjectName,@Param("classHour1") Integer classHour1,@Param("classHour2") Integer classHour2);

    // 批量删除课程
    int deleteByIds(@Param("ids") List<Integer> ids);
}
