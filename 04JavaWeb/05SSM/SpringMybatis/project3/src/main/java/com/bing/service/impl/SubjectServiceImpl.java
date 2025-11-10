package com.bing.service.impl;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class SubjectServiceImpl implements SubjectService {

    // 使用@Resource 或 @Autowired注解 注入Ioc容器中存在的Bean
    // 注入SubjectMapper
    @Resource
    private SubjectMapper subjectMapper;

    // 在业务逻辑层，对需要添加事务管理的方法添加@Transactional注解
    @Transactional
    @Override
    public void addSubject() {
        // 同时添加两条课程信息，要么都执行，要么都不执行：保证事务的原子性
        Subject subject1 = new Subject(null,"课程A",100,1);
        Subject subject2 = new Subject(null,"课程B",200,2);
        subjectMapper.addSubject(subject1);
        if(true){
            throw  new RuntimeException("发生异常！");
        }
        subjectMapper.addSubject(subject2);
    }
}
