package com.bing.mapper;

import com.bing.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 年级Mapper
 */
@Mapper
public interface GradeMapper {
    /**
     * 查询全部年级
     * @return 年级集合
     */
    @Select("select * from grade")
    List<Grade> findAll();

    /**
     * 根据年级编号查询年级
     * @param gradeId 年级编号
     * @return 年级对象
     */
    @Select("select * from Grade where gradeId=#{gradeId}")
    Grade findById(Integer gradeId);
}
