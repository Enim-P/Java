package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentNo;
    private String loginPwd;
    private String studentName;
    private String sex;
    private Integer gradeId;
    private String phone;
    private String address;
    private LocalDateTime bornDate;
    private String email;
    private String identityCard;
}
