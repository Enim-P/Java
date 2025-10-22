package com.bing.pojo;

import lombok.Data;

import java.util.List;

/**
 * 年级
 */
@Data
public class Grade {
    private int gradeId;
    private String gradeName;

    // 年级跟课程的关系是 一对多
    // 年级的课程集合
    private List<Subject> subjectList;
}
