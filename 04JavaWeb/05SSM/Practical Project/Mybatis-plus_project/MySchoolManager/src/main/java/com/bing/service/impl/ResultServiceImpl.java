package com.bing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.annotation.LogAnnotation;
import com.bing.mapper.ResultMapper;
import com.bing.mapper.StudentMapper;
import com.bing.mapper.SubjectMapper;
import com.bing.pojo.PageBean;
import com.bing.pojo.Result;
import com.bing.pojo.Student;
import com.bing.pojo.Subject;
import com.bing.service.ResultService;
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
        return resultMapper.updateById(result);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(Integer resultId) {
        return  resultMapper.deleteById(resultId);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int deleteByIds(List<Integer> ids) {
        return resultMapper.deleteBatchIds(ids);
    }

    @Override
    public Result findById(Integer resultId) {
        Result result = resultMapper.selectById(resultId);
        if(result!=null){
            // 完善成绩的学生和课程信息
            Student student = studentMapper.selectById(result.getStudentNo());
            Subject subject = subjectMapper.selectById(result.getSubjectId());
            result.setStudent(student);
            result.setSubject(subject);
        }
        return result;
    }

    @Override
    public PageBean<Result> findByCondition(String studentNo, Integer subjectId, Integer pageIndex, Integer pageSize) {
        IPage<Result> page = new Page<>(pageIndex,pageSize);
        LambdaQueryWrapper<Result> qw = new LambdaQueryWrapper<>();
        qw.eq(!"".equals(studentNo) ,Result::getStudentNo,studentNo);
        qw.eq(0 != subjectId,Result::getSubjectId,subjectId);
        resultMapper.selectPage(page,qw);
        List<Result> results = page.getRecords();
        // 完善每个成绩对应的学生和课程信息
        results.forEach(r->{
            Student student = studentMapper.selectById(r.getStudentNo());
            Subject subject = subjectMapper.selectById(r.getSubjectId());
            r.setStudent(student);
            r.setSubject(subject);
        });
        PageBean<Result> pageBean = new PageBean<>(page.getTotal(),results);
        return pageBean;
    }
}
