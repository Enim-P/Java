package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;
}
