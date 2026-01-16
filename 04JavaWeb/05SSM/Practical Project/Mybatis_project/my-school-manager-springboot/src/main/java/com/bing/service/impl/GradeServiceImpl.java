package com.bing.service.impl;

import com.bing.mapper.GradeMapper;
import com.bing.pojo.Grade;
import com.bing.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年级Servie实现类
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    GradeMapper gradeMapper;

    @Override
    public List<Grade> findAll() {
        return gradeMapper.findAll();
    }

    @Override
    public Grade findById(Integer gradeId) {
        return gradeMapper.findById(gradeId);
    }
}
