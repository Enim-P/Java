package com.bing.mapper;

import com.bing.pojo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 成绩Mapper
 */
@Mapper
public interface ResultMapper {
    /**
     * 新增成绩
     * @param result 成绩对象
     * @return 受影响行数
     */
    @Options(keyProperty = "resultId",useGeneratedKeys = true)   //回传成绩编号
    @Insert("insert into result(studentNo,subjectId,studentResult,examDate)" +
            " values(#{studentNo},#{subjectId},#{studentResult},#{examDate})")
    int insert(Result result);

    /**
     * 修改成绩
     * @param result 成绩对象
     * @return 受影响行数
     */
    @Update("update result set studentNo=#{studentNo},subjectId=#{subjectId}," +
            "studentResult=#{studentResult},examDate=#{examDate} " +
            "where resultId=#{resultId}")
    int update(Result result);

    /**
     * 删除成绩
     * @param resultId 成绩编号
     * @return 受影响行数
     */
    @Delete("delete from result where resultId=#{resultId}")
    int delete(Integer resultId);

    /**
     * 根据ids批量删除成绩信息
     * @param ids ids集合
     * @return 受影响行数
     */
    int deleteByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据学号删除成绩信息
     * @param studentNo 学号
     * @return 受影响行数
     */
    @Delete("delete from result where studentNo=#{studentNo}")
    int deleteByStudentNo(String studentNo);

    /**
     * 根据课程编号删除成绩信息
     * @param subjectId 课程编号
     * @return 受影响行数
     */
    @Delete("delete from result where subjectId=#{subjectId}")
    int deleteBySubjectId(Integer subjectId);

    /**
     * 根据id查询成绩
     * @param resultId 成绩id
     * @return  成绩对象
     */
    @Select("select * from result where resultId=#{resultId}")
    Result findById(Integer resultId);

    /**
     * 根据条件查询成绩
     * @param studentNo 学号
     * @param subjectId 课程编号
     * @return 成绩集合
     */
    List<Result> findByCondition(@Param("studentNo") String studentNo,
                                 @Param("subjectId") Integer subjectId);
}
