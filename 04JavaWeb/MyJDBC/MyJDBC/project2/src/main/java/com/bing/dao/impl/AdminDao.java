package com.bing.dao.impl;

import com.bing.dao.BaseDao;
import com.bing.dao.IAdminDao;
import com.bing.pojo.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 管理员数据访问层实现类
 */
public class AdminDao extends BaseDao implements IAdminDao {

    @Override
    public Admin selectByLoginId(String loginId) {
        Admin admin = null;
        // 组织sql语句
        String sql = "select * from admin where loginId=?";
        // 执行sql语句，返回结果集对象
        ResultSet set = executeQuery(sql, loginId);
        try {
            if(set.next()){
                admin = new Admin();
                admin.setLoginId(set.getString("loginId"));
                admin.setLoginPwd(set.getString("loginPwd"));
                admin.setName(set.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            closeResource();
        }
        return admin;
    }
}
