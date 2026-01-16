package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 年级实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer gradeId;
    private String gradeName;
}
