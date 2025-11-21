package com.bing.service.impl;

import com.bing.mapper.GradeMapper;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Grade;
import com.bing.pojo.PageBean;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程Service实现类
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    SubjectMapper subjectMapper;

    @Resource
    GradeMapper gradeMapper;

    @Override
    public int insert(Subject subject) {
        return subjectMapper.insert(subject);
    }

    @Override
    public int update(Subject subject) {
        return subjectMapper.update(subject);
    }

    @Override
    public int delete(Integer subjectId) {
        return subjectMapper.delete(subjectId);
    }

    @Override
    public Subject findById(Integer subejctId) {
        Subject subject = subjectMapper.findById(subejctId);
        if(subject!=null){
            // 给课程对象添加年级信息
            Grade grade = gradeMapper.findById(subject.getGradeId());
            subject.setGrade(grade);
        }
        return subject;
    }

    @Override
    public PageBean<Subject> findByCondition(Integer gradeId, String subjectName, Integer pageIndex, Integer pageSize) {
        //查询总数量
        Long total = subjectMapper.findByConditionSize(gradeId,subjectName);
        //计算出分页跳过数量
        Integer skipSize = (pageIndex-1)*pageSize;
        //查询当前页课程数据
        List<Subject> subjects = subjectMapper.findByCondition(gradeId, subjectName, skipSize, pageSize);
        //创建一个分页数据返回
        PageBean<Subject> pageBean = new PageBean<>(total,subjects);
        return pageBean;
    }
}
