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
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                student.getStudentNo(),
                student.getLoginPwd(),
                student.getStudentName(),
                student.getSex(),
                student.getGradeId(),
                student.getPhone(),
                student.getAddress(),
                student.getBornDate(),
                student.getEmail(),
                student.getIdentityCard()
        };
        return executeUpdate(sql,params);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set " +
                "loginPwd=?,studentName=?,sex=?,gradeId=?,phone=?," +
                "address=?,bornDate=?,email=?,identityCard=? where studentNo=?";
        Object[] params = {
                student.getLoginPwd(),
                student.getStudentName(),
                student.getSex(),
                student.getGradeId(),
                student.getPhone(),
                student.getAddress(),
                student.getBornDate(),
                student.getEmail(),
                student.getIdentityCard(),
                student.getStudentNo()
        };
        return executeUpdate(sql,params);
    }

    @Override
    public int deleteStudent(String studentNo) {
        String sql = "delete from student where studentNo=?";
        return executeUpdate(sql,studentNo);
    }

    @Override
    public Student selectStudentByNo(String studentNo) {
        String sql = "select * from student where studentNo=?";
        ResultSet set = executeQuery(sql,studentNo);
        List<Student> students = setToList(set);
        if(students.size()>0){
            return students.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Student> selectAll() {
       String sql = "select * from student";
       ResultSet set = executeQuery(sql);
       return setToList(set);
    }

    @Override
    public List<Student> selectByGrade(int gradeId) {
        String sql = "select * from student where gradeId=?";
        ResultSet set = executeQuery(sql,gradeId);
        return setToList(set);
    }

    @Override
    public List<Student> selectByName(String studentName) {
        String sql = "select * from student where studentName like concat('%',?,'%')";
        ResultSet set = executeQuery(sql,studentName);
        return setToList(set);
    }

    @Override
    public List<Student> selectByGradeAndName(int gradeId, String studentName) {
        String sql = "select * from student where gradeId=? and studentName like concat('%',?,'%')";
        ResultSet set = executeQuery(sql,gradeId,studentName);
        return setToList(set);
    }

    // 将结果集中的数据读取出来返回List
    public List<Student> setToList(ResultSet set){
        List<Student> students = new ArrayList<>();
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

}
