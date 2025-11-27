package com.bing.service;

import com.bing.pojo.Admin;
import com.bing.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Service
 */
public interface AdminService {
    /**
     * 注册用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    int register(Admin admin);

    /**
     * 添加用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    int insert(Admin admin);

    /**
     * 修改用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    int update(Admin admin);

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPwd 原始密码
     * @param newPwd 新的密码
     * @return 受影响行数
     */
    int updatePwd(Integer id,String oldPwd,String newPwd);

    /**
     * 删除用户
     * @param id 用户id
     * @return 受影响行数
     */
    int delete(Integer id);

    /**
     * 根据登录名查询用户
     * @param loginId 登录名
     * @return 用户对象
     */
    Admin findByLoginId(String loginId);

    /**
     * 根据条件+分页查询用户
     * @param type 类型
     * @param name 姓名
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @return 用户分页数据
     */
    PageBean<Admin> findByCondition(String type,
                                    String name,
                                    Integer pageIndex,
                                    Integer pageSize);

}
