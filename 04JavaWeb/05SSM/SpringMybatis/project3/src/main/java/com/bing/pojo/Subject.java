package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private Integer subjectId;
    private String subjectName;
    private Integer classHour;
    private Integer gradeId;
}
