package com.bing.dao.impl;

import com.bing.dao.BaseDao;
import com.bing.dao.IStudentDao;
import com.bing.pojo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生数据访问类
 */
public class StudentDao extends BaseDao implements IStudentDao {
    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public int deleteStudent(String studentNo) {
        return 0;
    }

    @Override
    public List<Student> selectAll() {
       List<Student> students = new ArrayList<>();
       String sql = "select * from student";
       ResultSet set = executeQuery(sql);
       try{
           while(set.next()){
               Student s = new Student();
               s.setStudentNo(set.getString("studentNo"));
               s.setLoginPwd(set.getString("loginPwd"));
               s.setStudentName(set.getString("studentName"));
               s.setSex(set.getString("sex"));
               s.setGradeId(set.getInt("gradeId"));
               s.setPhone(set.getString("phone"));
               s.setBornDate((LocalDateTime) set.getObject("bornDate"));
               s.setAddress(set.getString("address"));
               s.setEmail(set.getString("email"));
               s.setIdentityCard(set.getString("identityCard"));
               students.add(s);
           }
       } catch (SQLException e){
           e.printStackTrace();
       } finally {
           closeResource();
       }
       return students;
    }

    @Override
    public List<Student> selectByGrade(int gradeId) {
        return null;
    }

    @Override
    public List<Student> selectByName(String studentName) {
        return null;
    }

    @Override
    public List<Student> selectByGradeAndName(int gradeId, String studentName) {
        return null;
    }
}
