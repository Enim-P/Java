package com.bing.mapper;

/**
 * 成绩Mapper
 */
public interface ResultMapper {
    // 根据学号查询成绩的数量
    int resultCountByStudentNo(String studentNo);
    // 根据学号删除成绩
    int deleteResultByStudentNo(String studentNo);
}
