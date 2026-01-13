package com.bing.project2;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.project2.mapper.UserMapper;
import com.bing.project2.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Project2ApplicationTests {

    @Resource
    private UserMapper userMapper;

    // 查询全部用户
    @Test
    void test1() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    // 查询单个用户
    @Test
    void test2(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    // 新增
    @Test
    void test3(){
        // 创建用户对象
        User user = new User();
        user.setName("周杰伦");
        user.setAge(30);
        user.setTel("15911111111");
        user.setPassword("123456");
        // 添加成功后，返回受影响的行数
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    // 修改
    @Test
    void test4(){
        User user = new User();
        user.setId(2010890418367098881L);  //注意：id是Long类型
        user.setName("王杰");
        // updateById方法是根据id修改其他信息，只修改赋值的字符
        // 修改成功后，返回受影响的行数
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }

    // 删除
    @Test
    void test5(){
        // deleteById方法根据id删除
        // 删除成功后，返回受影响的行数
        int rows = userMapper.deleteById(2010890418367098881L);
        System.out.println(rows);
    }

    // 分页查询
    @Test
    void test6(){
        // 创建一个分页对象，这里是查询第二页，每页五条数据
        IPage<User> page = new Page<>(2,5);
        userMapper.selectPage(page, null);
        System.out.println(page);
    }
}
