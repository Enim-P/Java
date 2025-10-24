package com.bing.project4.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 年级实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private int gradeId;
    private String gradeName;

    // 课程集合
    private List<Subject> subjectList;
}
