package com.bing.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 课程实体类
 */
@Setter
@Getter
@Accessors(chain = true)
public class Subject {
    public Subject(){
        System.out.println("Subject被创建了....");
    }
    private int subjectId;
    private String subjectName;
    private int classHour;
    private int gradeId;
}
