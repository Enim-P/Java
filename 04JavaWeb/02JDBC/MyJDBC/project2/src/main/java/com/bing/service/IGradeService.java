package com.bing.service;

import com.bing.pojo.Grade;

import java.util.List;

/**
 * 年级业务逻辑层接口
 */
public interface IGradeService {
    //查询全部年级
    List<Grade> selectAll();

    //根据id查询
    Grade selectOne(int gradeId);
}
