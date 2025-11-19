package com.bing.service.impl;

import com.bing.dao.SubjectDao;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程业务逻辑层实现类
 */
@Service   // 业务逻辑类
public class SubjectServiceImpl implements SubjectService {
    @Resource
    SubjectDao subjectDao;

    @Resource
    SubjectMapper subjectMapper;

    @Override
    public List<Subject> selectAll() {
        //return subjectDao.selectAll();
        return subjectMapper.selectAll();
    }
}
