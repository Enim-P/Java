package com.bing.service;

import com.bing.pojo.PageBean;
import com.bing.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 成绩Service
 */
public interface ResultService {
    /**
     * 新增成绩
     * @param result 成绩对象
     * @return 受影响行数
     */
    int insert(Result result);

    /**
     * 修改成绩
     * @param result 成绩对象
     * @return 受影响行数
     */
    int update(Result result);

    /**
     * 删除成绩
     * @param resultId 成绩编号
     * @return 受影响行数
     */
    int delete(Integer resultId);

    /**
     * 根据ids批量删除成绩信息
     * @param ids ids集合
     * @return 受影响行数
     */
    int deleteByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据id查询成绩
     * @param resultId 成绩id
     * @return  成绩对象
     */
    Result findById(Integer resultId);

    /**
     * 根据条件+分页查询成绩
     * @param studentNo 学号
     * @param subjectId 课程编号
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @return 成绩分页数据
     */
    PageBean<Result> findByCondition(String studentNo,
                                      Integer subjectId,
                                      Integer pageIndex,
                                      Integer pageSize);
}
