package com.bing.schoolmanager.service.impl;

import com.bing.schoolmanager.mapper.GradeMapper;
import com.bing.schoolmanager.pojo.Grade;
import com.bing.schoolmanager.service.GradeService;
import com.bing.schoolmanager.util.MybatisUtil;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeMapper gradeMapper = MybatisUtil.getSession(true)
            .getMapper(GradeMapper.class);
    @Override
    public Grade getGradeById(int gradeId) {
        return gradeMapper.getGradeById(gradeId);
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeMapper.getAllGrade();
    }
}
