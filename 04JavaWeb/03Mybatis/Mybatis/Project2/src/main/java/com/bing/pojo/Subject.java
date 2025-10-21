package com.bing.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 课程
 */
@Data
@Alias("kecheng")   //指定某个类，设置一个别名
public class Subject {
    private int subjectId;
    private String subjectName;
    private int classHour;
    private int gradeId;
}
