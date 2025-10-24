package com.bing.test;

import com.bing.pojo.Subject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

// 直接通过Mapper文件中的映射Id返回返回结果
public class Test1 {
    public static void main(String[] args) {
        //SqlSessionFactory：是SQL会话工厂
        //SqlSessionFactoryBuilder：是构建SQL会话工厂的对象，它通过build方法来构建
        //build方法，需要指定mybatis的配置文件来构建
        //build方法的第二个参数可以配置具体的环境，传递一个环境ID，通常可以省略采用默认的环境构建
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));

        //SQL会话工厂对象，通过openSession方法创建SQL会话（参数true，表示启动自动事务提交，执行一条SQL提交一次事务）
        //SQL会话是用来执行具体的数据库操作的，就类似于在jdbc中的数据执行对象Statement
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            // selectList方法直接将SQL语句映射成对应的类型集合返回
            // 参数是就是映射文件中对应的MapperId
            List<Subject> subjects = sqlSession.selectList("selectAllSubject");
            subjects.forEach(System.out::println);
        }
    }
}
