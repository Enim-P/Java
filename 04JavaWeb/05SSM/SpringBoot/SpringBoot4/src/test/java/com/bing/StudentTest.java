package com.bing;

import com.bing.mapper.StudentMapper;
import com.bing.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
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

    // 测试只修改部分字段
    @Test
    void testUpdate2(){
        Student student = new Student();
        student.setStudentNo("A1001");
        student.setStudentName("张飞");
        student.setPhone("10086");
        student.setAddress("北京");
        int rows = studentMapper.updateStudent2(student);
        System.out.println(rows);
    }

    // 测试查询全部
    @Test
    void testSelectAll(){
        List<Student> students = studentMapper.selectAll();
        System.out.println(students);
    }

    // 测试根据条件查询
    // 根据学号查询指定的学生
    @Test
    void testSelectCondition1(){
        String studentNo = "S1101001";
        Student student = studentMapper.selectByNo(studentNo);
        System.out.println(student);
    }

    // 根据姓名+性别查询
    @Test
    void testSelectCondition2(){
        String studentName = "王";
        String sex = "女";
        List<Student> students = studentMapper.selectByNameAndSex(studentName, sex);
        System.out.println(students);
    }

    // 根据姓名+性别+生日区间查询
    @Test
    void testSelectCondition3(){
        String studentName = "王";
        String sex = "女";
        String time1 = "1980-1-1";
        String time2 = "1989-12-31";
        List<Student> students = studentMapper.selectByNameAndSexAndBornDate(studentName, sex, time1, time2);
        System.out.println(students);
    }

    @Test
    void testSelectCondition4(){
        String studentName = "王";
        String sex = "女";
        String time1 = "1980-1-1";
        String time2 = "1989-12-31";
//        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(studentName, sex, time1, time2);
//        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(null,null,null,null);
//        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(studentName,null,null,null);
//        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(studentName,sex,null,null);
//        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(null,sex,null,null);
        List<Student> students = studentMapper.selectByNameAndSexAndBornDate2(null,null,time1,time2);
        System.out.println(students);
    }

    @Test
    void testSelectByNos(){
        List<String> nos = Arrays.asList("S1101001","S1101002","S1101003");
        List<Student> students = studentMapper.selectByNos(nos);
        System.out.println(students);
    }

}
