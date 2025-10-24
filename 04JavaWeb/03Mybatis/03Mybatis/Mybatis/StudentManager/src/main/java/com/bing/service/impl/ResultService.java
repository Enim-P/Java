package com.bing.service.impl;

import com.bing.mapper.ResultMapper;
import com.bing.service.IResultService;
import com.bing.util.MybatisUtil;

/**
 * 成绩业务逻辑类
 */
public class ResultService implements IResultService {
    // 创建数据访问层对象
    ResultMapper resultDao = MybatisUtil.getSession(true).getMapper(ResultMapper.class);
    @Override
    public int resultCountByStudentNo(String studentNo) {
        return resultDao.resultCountByStudentNo(studentNo);
    }

    @Override
    public int deleteResultByStudentNo(String studentNo) {
        return resultDao.deleteResultByStudentNo(studentNo);
    }
}
