package com.bing.schoolmanager.service;

import com.bing.schoolmanager.pojo.Grade;

import java.util.List;

public interface GradeService {
    Grade getGradeById(int gradeId);
    List<Grade> getAllGrade();
}
