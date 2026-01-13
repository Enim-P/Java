package com.bing.project2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.project2.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // BaseMapper是MyBatis-Plus提供的一个接口
    // 我们自己的Mapper只需要基础这个接口，就可使用单表的增删改查业务
}
