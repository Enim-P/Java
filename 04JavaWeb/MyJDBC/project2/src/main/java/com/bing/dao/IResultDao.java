package com.bing.dao;

/**
 * 成绩数据访问层接口
 */
public interface IResultDao {
    // 根据学号查询成绩的数量
    int resultCountByStudentNo(String studentNo);
    // 根据学号删除成绩
    int deleteResultByStudentNo(String studentNo);
}
