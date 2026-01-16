package com.bing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.annotation.LogAnnotation;
import com.bing.mapper.GradeMapper;
import com.bing.mapper.ResultMapper;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Grade;
import com.bing.pojo.PageBean;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
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
        return subjectMapper.updateById(subject);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(Integer subjectId) {
        //要先删除课程对应的成绩，在删除课程
        QueryWrapper qw = new QueryWrapper();
        qw.eq("subjectId",subjectId);
        resultMapper.delete(qw);
        return subjectMapper.deleteById(subjectId);
    }

    @Override
    public Subject findById(Integer subejctId) {
        Subject subject = subjectMapper.selectById(subejctId);
        if(subject!=null){
            // 给课程对象添加年级信息
            Grade grade = gradeMapper.selectById(subject.getGradeId());
            subject.setGrade(grade);
        }
        return subject;
    }

    @Override
    public PageBean<Subject> findByCondition(Integer gradeId, String subjectName, Integer pageIndex, Integer pageSize) {
        IPage<Subject> page = new Page<>(pageIndex,pageSize);
        LambdaQueryWrapper<Subject> qw = new LambdaQueryWrapper();
        qw.eq(0!=gradeId,Subject::getGradeId,gradeId);
        qw.like(Subject::getSubjectName,subjectName);
        subjectMapper.selectPage(page,qw);
        List<Subject> subjects = page.getRecords();
        // 给每个课程添加年级信息
        subjects.forEach(s->{
            Grade grade = gradeMapper.selectById(s.getGradeId());
            s.setGrade(grade);
        });
        PageBean<Subject> pageBean = new PageBean<>(page.getTotal(),subjects);
        return pageBean;
    }
}
