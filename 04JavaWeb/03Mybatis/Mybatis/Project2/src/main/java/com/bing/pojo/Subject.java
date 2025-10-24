package com.bing.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * 课程
 */
@Data
@Accessors(chain = true)   //开启链式调用方法给属性赋值
@Alias("kecheng")   //指定某个类，设置一个别名
public class Subject {
    private int subjectId;
    private String subjectName;
    private int classHour;
    private int gradeId;

    // 课程跟年级的关系是 一对一
    // 课程的年级对象
    private Grade grade;
}
