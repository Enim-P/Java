package com.bing.service.impl;

import com.bing.annotation.LogAnnotation;
import com.bing.mapper.GradeMapper;
import com.bing.mapper.ResultMapper;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Grade;
import com.bing.pojo.PageBean;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程Service实现类
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    ResultMapper resultMapper;
    @Resource
    SubjectMapper subjectMapper;
    @Resource
    GradeMapper gradeMapper;

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int insert(Subject subject) {
        return subjectMapper.insert(subject);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int update(Subject subject) {
        return subjectMapper.update(subject);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(Integer subjectId) {
        //要先删除课程对应的成绩，在删除课程
        resultMapper.deleteBySubjectId(subjectId);
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

    // 手动实现分页
    /*@Override
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
    }*/

    // 使用PageHelper实现分页
    @Override
    public PageBean<Subject> findByCondition(Integer gradeId, String subjectName, Integer pageIndex, Integer pageSize) {
        // 1.设置分页参数
        PageHelper.startPage(pageIndex,pageSize);
        // 2.执行查询
        List<Subject> subjects = subjectMapper.findByCondition2(gradeId, subjectName);
        // 给每个课程添加年级信息
        subjects.forEach(s->{
            Grade grade = gradeMapper.findById(s.getGradeId());
            s.setGrade(grade);
        });
        // 将查询结果转为Page<T>类型：它会帮你实现分页功能
        Page<Subject> pages = (Page<Subject>) subjects;
        // 3.封装PageBean对象返回
        PageBean<Subject> pageBean = new PageBean<>(pages.getTotal(),pages.getResult());
        return pageBean;
    }
}
