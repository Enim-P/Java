package com.bing.dao.impl;

import com.bing.dao.BaseDao;
import com.bing.dao.IResultDao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 成绩数据访问类
 */
public class ResultDao extends BaseDao implements IResultDao {
    @Override
    public int resultCountByStudentNo(String studentNo) {
        int count = 0;
        String sql = "select count(*) from result where studentNo=?";
        ResultSet set = executeQuery(sql,studentNo);
        try{
            if(set.next()){
                // 注意：数据库中列的索引从1开始
                count = (int)set.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeResource();
        }
        return count;
    }

    @Override
    public int deleteResultByStudentNo(String studentNo) {
        String sql = "delete from result where studentNo=?";
        return executeUpdate(sql,studentNo);
    }
}
