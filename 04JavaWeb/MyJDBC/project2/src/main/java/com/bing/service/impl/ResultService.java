package com.bing.service.impl;

import com.bing.dao.IResultDao;
import com.bing.dao.impl.ResultDao;
import com.bing.service.IResultService;

/**
 * 成绩业务逻辑类
 */
public class ResultService implements IResultService {
    // 创建数据访问层对象
    IResultDao resultDao = new ResultDao();
    @Override
    public int resultCountByStudentNo(String studentNo) {
        return resultDao.resultCountByStudentNo(studentNo);
    }

    @Override
    public int deleteResultByStudentNo(String studentNo) {
        return resultDao.deleteResultByStudentNo(studentNo);
    }
}
