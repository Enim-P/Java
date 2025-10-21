package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String no;
    private String name;
    private int age;
    private String sex;
    private double score;
}
