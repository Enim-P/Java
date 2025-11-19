package com.bing;

import com.bing.mapper.StudentMapper;
import com.bing.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class StudentTest {

    @Resource
    StudentMapper studentMapper;

    // 测试新增
    @Test
    void testInsert(){
        Student student = new Student(
                "A1001","123456","周杰伦","男",
                1,"123456","台北", LocalDateTime.now(),
                "123@123.com","123456"
        );
        int rows = studentMapper.insertStudent(student);
        System.out.println(rows);
    }

    // 测试删除
    @Test
    void testDelete(){
        String studentNo = "A1001";
        int rows = studentMapper.deleteStudent(studentNo);
        System.out.println(rows);
    }

    // 测试修改
    @Test
    void testUpdate(){
        Student student = new Student(
                "A1001","123456","张学友","男",
                1,"123456","香港", LocalDateTime.now(),
                "123@123.com","123456"
        );
        int rows = studentMapper.updateStudent(student);
        System.out.println(rows);
    }

    // 测试查询全部
    @Test
    void testSelectAll(){
        List<Student> students = studentMapper.selectAll();
        System.out.println(students.size());
    }
}
