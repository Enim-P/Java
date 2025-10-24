package com.bing.mapper;

import com.bing.pojo.Subject;

public interface SubjectMapper {
    Subject selectOneSubject(int subjectId);

    Subject selectOneSubject2(int subjectId);

    int addSubject(Subject subject);
}
