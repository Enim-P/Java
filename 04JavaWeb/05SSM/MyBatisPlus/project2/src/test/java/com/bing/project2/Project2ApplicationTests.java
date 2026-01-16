package com.bing.project2;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.project2.mapper.UserMapper;
import com.bing.project2.pojo.User;
import com.bing.project2.pojo.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("本页数量："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
        // 当前页数据
        page.getRecords().forEach(System.out::println);
    }

    // 条件查询（条件字段使用字符串硬编码）
    @Test
    void test7(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        // 条件为age等于15
        //qw.eq("age",15);
        // 条件为age小于15
        //qw.lt("age",15);
        // 条件为age大于15
        qw.gt("age",15);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 条件查询（条件字段使用lambda，好处是在编译阶段减少写错的风险）
    @Test
    void test8(){
        // 方式一：QueryWrapper对象,点lambda()方法
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().gt(User::getAge,15);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 条件查询（条件字段使用lambda，好处是在编译阶段减少写错的风险）
    @Test
    void test9(){
        // 方式二：直接创建LambdaQueryWrapper条件对象，它只支持lambda，不支持字符串硬编码
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper();
        qw.gt(User::getAge,15);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 多条件查询（AND）
    @Test
    void  test10(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 查询年龄范围在15到30岁之间的信息
        //qw.gt(User::getAge,15);
        //qw.lt(User::getAge,30);
        // 多条件支持链式调用，默认是AND关系
        qw.gt(User::getAge,15).lt(User::getAge,30);
        // 注意：默认情况下无论添加多少条件，都是并且关系（ADN）
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 多条件查询（OR）
    @Test
    void test11(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 查询年龄范围大于等于30 或者 小于等于15
        // 通过or()方法，拼接或者关系
        qw.ge(User::getAge,30).or().le(User::getAge,15);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
        // eq：等于
        // gt：大于
        // lt：小于
        // ge：大于等于
        // le：小于等于
    }

    // null值判断（添加if条件判断）
    @Test
    void test12(){
        // 如果只有第一个年龄条件有值，判断大于该年龄
        // 如果只有第二个年龄条件有值，判断小于该年龄
        // 如果两个年龄条件都有值，判断大于第一个年龄并且小于第二个年龄
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 创建用户条件对象
        UserQuery uq = new UserQuery();
        uq.setAge(15);
        uq.setAge2(30);
        // 判断两个比较的年龄是否不为null
        if(null != uq.getAge()){
            qw.gt(User::getAge,uq.getAge());
        }
        if(null != uq.getAge2()){
            qw.lt(User::getAge,uq.getAge2());
        }
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // null值判断（可以不条件if条件判断，直接在方法中传条件）
    @Test
    void test13(){
        // 如果只有第一个年龄条件有值，判断大于该年龄
        // 如果只有第二个年龄条件有值，判断小于该年龄
        // 如果两个年龄条件都有值，判断大于第一个年龄并且小于第二个年龄
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 创建用户条件对象
        UserQuery uq = new UserQuery();
        uq.setAge(15);
        uq.setAge2(30);
        // 将条件写到方法参数中
        // gt方法的的第一个参数满足条件，才执行gt方法
        qw.gt(null!=uq.getAge(),User::getAge,uq.getAge())
                .lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 查询指定的列
    @Test
    void test14(){
       /* QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("name","age");*/
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 只查询姓名和年龄
        qw.select(User::getName,User::getAge);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 聚合查询
    @Test
    void test15(){
        QueryWrapper qw = new QueryWrapper();
        // 指定查询的列，这个列是一个聚合函数
        qw.select("count(*) as count","max(age) as maxAge",
                "min(age) as minAge","avg(age) as avgAge","sum(age) as sumAge");
        List<Map<String,Object>> list = userMapper.selectMaps(qw);
        Map<String,Object> map = list.get(0);
        System.out.println("总数量："+map.get("count"));
        System.out.println("最大年龄："+map.get("maxAge"));
        System.out.println("最小年龄："+map.get("minAge"));
        System.out.println("平均年龄："+map.get("avgAge"));
        System.out.println("总年龄："+map.get("sumAge"));
    }

    // 分组查询
    @Test
    void test16(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        // 统计数量
        qw.select("count(*) as count","name");
        // 根据姓名分组
        qw.groupBy("name");
        // 查询每个姓名有多少条记录
        List<Map<String, Object>> maps = userMapper.selectMaps(qw);
        maps.forEach(map->{
            System.out.println(map.get("name")+"的数量："+map.get("count"));
        });
    }

    // 范围查询
    @Test
    void test17(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 查询年龄在15到30之间的信息，大于等于15 小于等于30
        qw.between(User::getAge,15,30);
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 模糊查询
    @Test
    void test18(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // name like '%r%'
        //qw.like(User::getName,"r");
        // name like '%y'
        //qw.likeLeft(User::getName,'y');
        // name like 'J%'
        qw.likeRight(User::getName,"J");
        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    // 排序查询
    @Test
    void test19(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        // 参数1：返回true表示排序，否则不排序
        // 参数2：返回true表示升序，否则是降序
        qw.orderBy(true,true,User::getAge);
        // 可以条件多个排序字段（先根据主排序字段排序，数据相同的再根据子排序字段排序）
        //qw.orderBy(false,true,User::getTel);
        List<User> users = userMapper.selectList(qw);
        users.forEach(System.out::println);
    }

}
