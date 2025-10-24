package com.bing.test;

import com.bing.mapper.StudentMapper;
import com.bing.pojo.Student;
import com.bing.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Test1 {

    // @Test注解添加测试方法
    // 测试方法必须是public，不能是静态方法，返回值必须是void，必须没有任何参数
    @Test
    public void method1(){
        System.out.println("测试方法1");
    }

    @Test
    public void method2(){
        int num1 = 100;
        int num2 = 100;
        // Assert是junit提供的一个工具类，它提供了各种数据的比较方法
        Assert.assertEquals(num1,num2);
    }

    @Test
    public void method3(){
        int[] arr1 = {11,22,33,44};
        int[] arr2 = {44,33,22,11};
        Arrays.sort(arr2);
        // 比较两个数组的值是否一致
        Assert.assertArrayEquals(arr1,arr2);
    }

    // 对数据访问接口的功能进行测试
    @Test
    public void method4(){
        try(SqlSession sqlSession = MybatisUtil.getSession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.selectStudentByNo("S1101001");
            System.out.println(student);
        }
    }
}
