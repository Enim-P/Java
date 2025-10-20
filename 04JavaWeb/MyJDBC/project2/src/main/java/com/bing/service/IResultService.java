package com.bing.service;

/**
 * 成绩业务逻辑层接口
 */
public interface IResultService {
    // 根据学号查询成绩的数量
    int resultCountByStudentNo(String studentNo);
    // 根据学号删除成绩
    int deleteResultByStudentNo(String studentNo);
}
