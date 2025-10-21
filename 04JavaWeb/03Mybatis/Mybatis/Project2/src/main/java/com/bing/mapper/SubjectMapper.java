package com.bing.mapper;

import com.bing.pojo.Kc;
import com.bing.pojo.Subject;

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
}
