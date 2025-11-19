package com.bing;

import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBoot4ApplicationTests {

    @Resource
    SubjectService subjectService;

    @Test
    void testSelectAllSubject() {
        List<Subject> subjects = subjectService.selectAll();
        subjects.forEach(System.out::println);
    }

}
