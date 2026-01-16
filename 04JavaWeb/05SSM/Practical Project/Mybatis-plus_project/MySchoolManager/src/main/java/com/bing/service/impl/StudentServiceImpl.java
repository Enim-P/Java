package com.bing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.annotation.LogAnnotation;
import com.bing.mapper.GradeMapper;
import com.bing.mapper.ResultMapper;
import com.bing.mapper.StudentMapper;
import com.bing.pojo.Grade;
import com.bing.pojo.PageBean;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 学生Service实现类
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    ResultMapper resultMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    GradeMapper gradeMapper;

    @Transactional
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Transactional
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int update(Student student) {
        return studentMapper.updateById(student);
    }

    // 添加spring事务管理
    // @Transactional注解的常用属性：
    // rollbackFor：指定回滚的异常，比如指定为IOException.class，就只会在发生IOException异常时回滚
    // propagation：指定传播行为（指的是当一个事务方法被另一个事务方法调用时，这个事务方法应该何时进行事务控制）
    // 属性值是Propagation枚举类型，默认值是REQUIRED
    //  - REQUIRED：需要事务，有则加入，无则创建新事务
    //  - REQUIRES_NEW：需要新事务，无论有无，总是创建新事务
    /*
        总结：
        大部分情况下我们使用REQUIRED即可，当我们不希望事务直接相互影响时，可以使用REQUIRES_NEW。
        比如：下订单前需要记录日志，无论订单保存成功与否，都要保证日志能够成功记录。
    */
    @Transactional
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(String studentNo) {
        //删除该学生之前，要先删除该学生的成绩信息
        QueryWrapper qw = new QueryWrapper();
        qw.eq("studentNo",studentNo);
        resultMapper.delete(qw);
        return studentMapper.deleteById(studentNo);
    }

    @Override
    public Student findByNo(String studentNo) {
        Student student = studentMapper.selectById(studentNo);
        if(student!=null){
            Grade grade = gradeMapper.selectById(student.getGradeId());
            student.setGrade(grade);
        }
        return student;
    }

    @Override
    public PageBean<Student> findByCondition(Integer gradeId,
                                      String studentName,
                                      Integer pageIndex,
                                      Integer pageSize) {
        IPage<Student> page = new Page<>(pageIndex,pageSize);
        LambdaQueryWrapper<Student> qw = new LambdaQueryWrapper<>();
        qw.eq(0!=gradeId,Student::getGradeId,gradeId);
        qw.like(Student::getStudentName,studentName);
        // 执行分页查询
        studentMapper.selectPage(page,qw);
        List<Student> students = page.getRecords();
        //给每个学生添加年级信息
        students.forEach(s->{
            Grade grade = gradeMapper.selectById(s.getGradeId());
            s.setGrade(grade);
        });
        PageBean<Student> pageBean = new PageBean<>(page.getTotal(),students);
        return pageBean;
    }
}
