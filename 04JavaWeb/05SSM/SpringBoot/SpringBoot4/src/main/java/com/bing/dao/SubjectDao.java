package com.bing.dao;

import com.bing.pojo.Subject;

import java.util.List;

/**
 * 课程数据访问层接口
 */
public interface SubjectDao {
    List<Subject> selectAll();
}
