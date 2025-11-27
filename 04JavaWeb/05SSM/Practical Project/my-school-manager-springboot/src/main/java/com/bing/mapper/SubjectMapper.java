package com.bing.mapper;

import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 课程Mapper
 */
@Mapper
public interface SubjectMapper {
    /**
     * 新增课程
     * @param subject 课程对象
     * @return 受影响行数
     */
    @Options(keyColumn = "subejctId",useGeneratedKeys = true)   // 主键回传
    @Insert("insert into subject(subjectName,classHour,gradeId) " +
            "values(#{subjectName},#{classHour},#{gradeId})")
    int insert(Subject subject);

    /**
     * 修改课程
     * @param subject 课程对象
     * @return 受影响行数
     */
    @Update("update subject set subjectName=#{subjectName},classHour=#{classHour}," +
            "gradeId=#{gradeId} where subjectId=#{subjectId}")
    int update(Subject subject);

    /**
     * 删除课程
     * @param subjectId 课程编号
     * @return 受影响行数
     */
    @Delete("delete from subject where subjectId=#{subjectId}")
    int delete(Integer subjectId);

    /**
     * 根据课程编号查询课程
     * @param subejctId 课程编号
     * @return 课程对象
     */
    @Select("select * from subject where subjectId=#{subjectId}")
    Subject findById(Integer subejctId);


    /**
     * 根据条件查询课程的数量
     * @param gradeId 年级编号
     * @param subjectName 课程名称
     * @return 总数量
     */
    Long findByConditionSize(@Param("gradeId") Integer gradeId,
                             @Param("subjectName") String subjectName);
    /**
     * 条件+分页查询课程
     * @param gradeId 年级编号
     * @param subjectName 课程名称
     * @param skipSize 跳过数量
     * @param pageSize 每页数量
     * @return 课程集合
     */
    List<Subject> findByCondition(@Param("gradeId") Integer gradeId,
                         @Param("subjectName") String subjectName,
                         @Param("skipSize") Integer skipSize,
                         @Param("pageSize") Integer pageSize);

    /**
     * 条件查询课程
     * @param gradeId 年级编号
     * @param subjectName 课程名称
     * @return 课程集合
     */
    List<Subject> findByCondition2(@Param("gradeId") Integer gradeId,
                                  @Param("subjectName") String subjectName);

}
