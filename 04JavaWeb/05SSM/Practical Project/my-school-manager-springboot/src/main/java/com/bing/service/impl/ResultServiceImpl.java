package com.bing.service.impl;

import com.bing.annotation.LogAnnotation;
import com.bing.mapper.ResultMapper;
import com.bing.mapper.StudentMapper;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.PageBean;
import com.bing.pojo.Result;
import com.bing.pojo.Student;
import com.bing.pojo.Subject;
import com.bing.service.ResultService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成绩Service实现类
 */
@Service
public class ResultServiceImpl implements ResultService {
    @Resource
    ResultMapper resultMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    SubjectMapper subjectMapper;

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int insert(Result result) {
        return resultMapper.insert(result);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int update(Result result) {
        return resultMapper.update(result);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(Integer resultId) {
        return resultMapper.delete(resultId);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int deleteByIds(List<Integer> ids) {
        return resultMapper.deleteByIds(ids);
    }

    @Override
    public Result findById(Integer resultId) {
        Result result = resultMapper.findById(resultId);
        if(result!=null){
            // 完善成绩的学生和课程信息
            Student student = studentMapper.findByNo(result.getStudentNo());
            Subject subject = subjectMapper.findById(result.getSubjectId());
            result.setStudent(student);
            result.setSubject(subject);
        }
        return result;
    }

    @Override
    public PageBean<Result> findByCondition(String studentNo, Integer subjectId, Integer pageIndex, Integer pageSize) {
        //开启分页功能
        PageHelper.startPage(pageIndex,pageSize);
        List<Result> results = resultMapper.findByCondition(studentNo, subjectId);
        // 完善每个成绩对应的学生和课程信息
        results.forEach(r->{
            Student student = studentMapper.findByNo(r.getStudentNo());
            Subject subject = subjectMapper.findById(r.getSubjectId());
            r.setStudent(student);
            r.setSubject(subject);
        });
        Page<Result> pages = (Page<Result>) results;
        PageBean<Result> pageBean = new PageBean<>(pages.getTotal(),pages.getResult());
        return pageBean;
    }
}
