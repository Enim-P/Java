package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 成绩实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
