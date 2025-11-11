package com.bing.service;

import com.bing.pojo.Subject;

import java.util.List;

public interface SubjectService {
    Subject getSubjectById(Integer id);

    List<Subject> getSubjects();

    int addSubject();

    int updateSubject(Subject subject);

    int deleteSubject(Integer id);
}
