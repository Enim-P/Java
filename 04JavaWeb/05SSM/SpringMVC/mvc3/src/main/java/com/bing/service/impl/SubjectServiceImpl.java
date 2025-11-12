package com.bing.service.impl;

import com.bing.mapper.SubjectMapper;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/*
   @Component：用注册组件，就是注册Spring管理的bean
   @Controller，@Service，@Repository 是@Component的衍生注解，目的是为了见名知意
   @Controller：专门用于注册控制器
   @Service：专门用于注册业务逻辑类
   @Repository：专门用于数据访问类，
   由于我们在实际开发中数据访问层通常会使用Mybatis，所以该组件不常用，在Mybatis中它自己的注解@Mapper
*/

@Service
public class SubjectServiceImpl implements SubjectService {
    @Resource
    private SubjectMapper subjectMapper;

    @Transactional
    @Override
    public int addSubject(Subject subject) {
        return subjectMapper.addSubject(subject);
    }

    @Transactional
    @Override
    public int updateSubject(Subject subject) {
        return subjectMapper.updateSubject(subject);
    }

    @Transactional
    @Override
    public int deleteSubject(Integer id) {
        return subjectMapper.deleteSubject(id);
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectMapper.getSubjectById(id);
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectMapper.getSubjects();
    }
}
