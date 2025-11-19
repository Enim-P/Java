package com.bing.mapper;

import com.bing.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 学生Mapper
 */
@Mapper
public interface StudentMapper {
    // 新增
//    @Insert("insert into student(studentNo,loginPwd,studentName,sex,gradeId," +
//            "phone,address,bornDate,email,identityCard) values(#{studentNo}," +
//            "#{loginPwd},#{studentName},#{sex},#{gradeId},#{phone},#{address}," +
//            "#{bornDate},#{email},#{identityCard})")
    int insertStudent(Student student);

    // 删除
    // ${参数}：采用的是字符串拼接，可以抓住一些规则，注入SQL，不安全
    // #{参数}：采用的是SQL参数，可以放置SQL注入，更安全
    //@Delete("delete from student where studentNo='${studentNo}'")
    //@Delete("delete from student where studentNo=#{studentNo}")
    int deleteStudent(String studentNo);

    // 修改
//    @Update("update student set loginPwd=#{loginPwd},studentName=#{studentName}," +
//            "sex=#{sex},gradeId=#{gradeId},phone=#{phone},address=#{address}," +
//            "bornDate=#{bornDate},email=#{email},identityCard=#{identityCard}" +
//            " where studentNo=#{studentNo}")
    int updateStudent(Student student);

    // 查询全部
    //@Select("select * from student")
    List<Student> selectAll();
}
