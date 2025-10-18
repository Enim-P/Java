package com.bing.dao.impl;

import com.bing.dao.BaseDao;
import com.bing.dao.IGradeDao;
import com.bing.pojo.Grade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 年级数据访问类
 */
public class GradeDao extends BaseDao implements IGradeDao {
    @Override
    public List<Grade> selectAll() {
        List<Grade> grades = new ArrayList<>();
        String sql = "select * from grade";
        ResultSet set = executeQuery(sql);
        try{
            while (set.next()){
                Grade grade = new Grade();
                grade.setGradeId(set.getInt("gradeId"));
                grade.setGradeName(set.getString("gradeName"));
                grades.add(grade);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeResource();
        }
        return grades;
    }

    @Override
    public Grade selectOne(int gradeId) {
        Grade grade = new Grade();
        String sql = "select * from grade where gardeId=?";
        ResultSet set = executeQuery(sql, gradeId);
        try{
            if(set.next()){
                grade.setGradeId(set.getInt("gradeId"));
                grade.setGradeName(set.getString("gradeName"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return grade;
    }
}
