package com.bing.service;

import com.bing.annotation.LogAnnotation;
import com.bing.pojo.PageBean;
import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程Service
 */
public interface SubjectService {
    /**
     * 新增课程
     * @param subject 课程对象
     * @return 受影响行数
     */
    int insert(Subject subject);

    /**
     * 修改课程
     * @param subject 课程对象
     * @return 受影响行数
     */
    int update(Subject subject);

    /**
     * 删除课程
     * @param subjectId 课程编号
     * @return 受影响行数
     */
    int delete(Integer subjectId);

    /**
     * 根据课程编号查询课程
     * @param subejctId 课程编号
     * @return 课程对象
     */
    Subject findById(Integer subejctId);

    /**
     * 根据条件+分页查询课程
     * @param gradeId 年级编号
     * @param subjectName 年级名称
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @return 课程分页数据
     */
    PageBean<Subject> findByCondition(Integer gradeId,
                                      String subjectName,
                                      Integer pageIndex,
                                      Integer pageSize);
}
