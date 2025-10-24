package com.bing.mapper;

import com.bing.pojo.Grade;

import java.util.List;

/**
 * 年级Mapper
 */
public interface GradeMapper {
    //查询全部年级
    List<Grade> selectAll();

    //根据id查询
    Grade selectOne(int gradeId);
}
