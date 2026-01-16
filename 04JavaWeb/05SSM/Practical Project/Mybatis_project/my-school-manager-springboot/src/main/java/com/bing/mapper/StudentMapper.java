package com.bing.mapper;

import com.bing.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 学生Mapper
 */
@Mapper
public interface StudentMapper {
    /**
     * 新增学生
     * @param student 学生对象
     * @return 受影响行数
     */
    @Insert("insert into student(studentNo,loginPwd,studentName,sex,gradeId,phone,address,bornDate,email,identityCard)" +
            " values(#{studentNo},#{loginPwd},#{studentName},#{sex},#{gradeId},#{phone},#{address},#{bornDate},#{email},#{identityCard})")
    int insert(Student student);

    /**
     * 修改学生
     * @param student 学生对象
     * @return 受影响行数
     */
    @Update("update student set loginPwd=#{loginPwd},studentName=#{studentName},sex=#{sex},gradeId=#{gradeId}," +
            "phone=#{phone},address=#{address},bornDate=#{bornDate},email=#{email},identityCard=#{identityCard}" +
            " where studentNo=#{studentNo}")
    int update(Student student);

    /**
     * 删除学生
     * @param studentNo 学号
     * @return 受影响函数
     */
    @Delete("delete from student where studentNo=#{studentNo}")
    int delete(String studentNo);

    /**
     * 根据学号查询学生
     * @param studentNo 学号
     * @return  学生对象
     */
    @Select("select * from student where studentNo=#{studentNo}")
    Student findByNo(String studentNo);

    /**
     * 根据条件查询学生
     * @param gradeId 年级编号
     * @param studentName 学生姓名
     * @return 学生集合
     */
    List<Student> findByCondition(@Param("gradeId") Integer gradeId,@Param("studentName") String studentName);
}
