package com.bing.service;

import com.bing.annotation.LogAnnotation;
import com.bing.pojo.PageBean;
import com.bing.pojo.Student;

/**
 * 学生Service
 */
public interface StudentService {
    /**
     * 新增学生
     * @param student 学生对象
     * @return 受影响行数
     */
    int insert(Student student);

    /**
     * 修改学生
     * @param student 学生对象
     * @return 受影响行数
     */
    int update(Student student);

    /**
     * 删除学生
     * @param studentNo 学号
     * @return 受影响函数
     */
    int delete(String studentNo);

    /**
     * 根据学号查询学生
     * @param studentNo 学号
     * @return  学生对象
     */
    Student findByNo(String studentNo);

    /**
     * 根据条件+分页查询学生
     * @param gradeId 年级编号
     * @param studentName 学生姓名
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @return 学生分页数据
     */
    PageBean<Student> findByCondition(Integer gradeId,
                                      String studentName,
                                      Integer pageIndex,
                                      Integer pageSize);
}
