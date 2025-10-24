package com.bing.project4.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis工具类
 */
public class MybatisUtil {
    // SQL会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    // 在类加载时创建SQL会话工厂
    static {
        sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
    }

    /**
     * 获取一个新的会话
     * @param autoCommit 是否开启自动事务提交
     * @return SqlSession对象
     */
    public static SqlSession getSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }
}
