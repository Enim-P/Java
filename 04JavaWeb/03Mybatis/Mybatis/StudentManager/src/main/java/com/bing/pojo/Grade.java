package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 年级
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private int gradeId;
    private String gradeName;
}
