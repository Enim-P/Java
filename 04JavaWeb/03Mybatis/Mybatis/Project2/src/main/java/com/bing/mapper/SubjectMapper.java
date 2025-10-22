package com.bing.mapper;

import com.bing.pojo.Kc;
import com.bing.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程数据访问接口
 */
public interface SubjectMapper {

    // 接口方法
    List<Subject> selectAllSubject();

    List<Map> selectAllSubject2();

    List<Kc> selectAllSubject3();

    List<Subject> selectAllSubject4();

    Subject selectOneSubject(int subjectId);

    // 多个SQL参数，需要通过@Param注解定义
    List<Subject> selectSubjectsByGradeIdAndName(@Param("gradeId") int gradeId,
                                                 @Param("subjectName") String subjectName);

    int addSubject(Subject subject);

    int updateSubject(Subject subject);

    int deleteSubject(int subjectId);

    // 动态SQL - if
    List<Subject> selectSubjectsByGradeId(int gradeId);
    // 动态SQL - choose
    List<Subject> selectSubjectsByGradeId2(int gradeId);
    // 动态SQL - foreach：批量删除
    int deleteSubjects(@Param("subjectIds") List<Integer> subjectIds);
    // 动态SQL - foreach：批量插入
    int addSubjects(@Param("subjects") List<Subject> subjects);
    // 动态SQL - where
    List<Subject> selectSubjectsByCondition(
            @Param("gradeId") Integer gradeId,
            @Param("subjectName") String subjectName
    );
}
