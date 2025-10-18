package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 学生
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentNo;
    private String loginPwd;
    private String studentName;
    private String sex;
    private int gradeId;
    private String phone;
    private String address;
    private LocalDateTime bornDate;
    private String email;
    private String identityCard;

    // 学生的年级对象
    private Grade grade;
}
