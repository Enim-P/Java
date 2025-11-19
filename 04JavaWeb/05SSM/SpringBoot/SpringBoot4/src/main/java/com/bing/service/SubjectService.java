package com.bing.service;

import com.bing.pojo.Subject;

import java.util.List;

/**
 * 课程业务逻辑层接口
 */
public interface SubjectService {
    List<Subject> selectAll();
}
