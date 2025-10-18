package com.bing.dao;

import com.bing.pojo.Grade;

import java.util.List;

/**
 * 年级数据访问层接口
 */
public interface IGradeDao {
    //查询全部年级
    List<Grade> selectAll();

    //根据id查询
    Grade selectOne(int gradeId);
}
