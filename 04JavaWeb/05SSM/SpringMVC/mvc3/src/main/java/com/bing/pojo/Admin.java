package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer id;
    private String loginId;
    private String loginPwd;
    private String name;
    private String sex;
    private String phone;
    private String type;
    private String photo;
    private LocalDateTime inDate;
}
