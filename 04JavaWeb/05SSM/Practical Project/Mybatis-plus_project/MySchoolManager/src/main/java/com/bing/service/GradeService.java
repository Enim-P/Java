package com.bing.service;

import com.bing.pojo.Grade;

import java.util.List;

/**
 * 年级Service
 */
public interface GradeService {
    /**
     * 查询全部年级
     * @return 年级集合
     */
    List<Grade> findAll();

    /**
     * 根据年级编号查询年级
     * @param gradeId 年级编号
     * @return 年级对象
     */
    Grade findById(Integer gradeId);
}
