package com.bing.mapper;

import com.bing.pojo.Grade;

import java.util.List;

/**
 * 年级数据访问接口
 */
public interface GradeMapper {
    List<Grade> selectAllGrade();
}
