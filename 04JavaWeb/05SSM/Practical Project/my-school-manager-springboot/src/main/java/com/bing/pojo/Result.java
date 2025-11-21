package com.bing.pojo;

import java.time.LocalDateTime;

/**
 * 成绩实体类
 */
public class Result {
    private Integer resultId;
    private String studentNo;
    private Integer subjectId;
    private Integer studentResult;
    private LocalDateTime examDate;

    // 成绩所属学生
    private Student student;
    // 成绩所属课程
    private Subject subject;
}
