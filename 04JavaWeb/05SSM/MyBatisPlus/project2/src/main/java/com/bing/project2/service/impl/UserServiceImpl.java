package com.bing.project2.service.impl;

import com.bing.project2.mapper.UserMapper;
import com.bing.project2.pojo.User;
import com.bing.project2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int upUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int delUser(Long id) {
        return userMapper.deleteById(id);
    }
}
