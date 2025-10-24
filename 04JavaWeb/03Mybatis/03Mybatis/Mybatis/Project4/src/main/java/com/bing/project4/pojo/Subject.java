package com.bing.project4.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Subject {
    // 手动补一个带两个参数的构造函数
    public Subject(int subjectId,String subjectName){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
    private int subjectId;
    private String subjectName;
    private int classHour;
    private int gradeId;

    // 课程的年级信息
    private Grade grade;
}
