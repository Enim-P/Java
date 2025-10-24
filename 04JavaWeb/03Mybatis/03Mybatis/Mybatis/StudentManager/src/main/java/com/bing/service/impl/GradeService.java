package com.bing.service.impl;

import com.bing.mapper.GradeMapper;
import com.bing.pojo.Grade;
import com.bing.service.IGradeService;
import com.bing.util.MybatisUtil;

import java.util.List;

/**
 * 年级业务逻辑实现类
 */
public class GradeService implements IGradeService {
    GradeMapper gradeDao = MybatisUtil.getSession(true)
            .getMapper(GradeMapper.class);
    @Override
    public List<Grade> selectAll() {
        return gradeDao.selectAll();
    }

    @Override
    public Grade selectOne(int gradeId) {
        return gradeDao.selectOne(gradeId);
    }
}
