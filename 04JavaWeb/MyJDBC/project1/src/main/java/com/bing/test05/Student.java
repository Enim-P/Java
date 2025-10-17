package com.bing.test05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentNo;
    private String loginPwd;
    private String studentName;
    private String sex;
    private int gardeId;
    private String phone;
    private String address;
    // LocalDateTime是日期+时间类型
    // LocalDate是日期类型
    // LocalTime是时间类型
    private LocalDateTime bornDate;
    private String email;
    private String identityCard;
}
