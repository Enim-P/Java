package com.bing.project2.service;

import com.bing.project2.pojo.User;

import java.util.List;

/**
 * 用户Service接口
 */
public interface UserService {
    // 查询全部用户
    List<User> findAllUser();

    // 根据id查询用户
    User findUserById(Long id);

    // 添加用户
    int addUser(User user);

    // 修改用户
    int upUser(User user);

    // 删除用户
    int delUser(Long id);
}
