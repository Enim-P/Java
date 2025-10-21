package com.bing.service.impl;

import com.bing.dao.IGradeDao;
import com.bing.dao.impl.GradeDao;
import com.bing.pojo.Grade;
import com.bing.service.IGradeService;

import java.util.List;

/**
 * 年级业务逻辑实现类
 */
public class GradeService implements IGradeService {
    IGradeDao gradeDao = new GradeDao();
    @Override
    public List<Grade> selectAll() {
        return gradeDao.selectAll();
    }

    @Override
    public Grade selectOne(int gradeId) {
        return gradeDao.selectOne(gradeId);
    }
}
