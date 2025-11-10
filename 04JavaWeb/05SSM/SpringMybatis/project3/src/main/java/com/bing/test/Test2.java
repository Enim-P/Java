package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.mapper.SubjectMapper;
import com.bing.service.SubjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        /*
            事务的隔离级别：
            1.读未提交：其他事务会读取当前事务尚未更改的提交（相当于读取的是这个事务暂时缓存的内容，并不是数据库中的内容）
            事务A 读取的是 事务B未提交之前的数据，事务B在提交之前，事务A可以读取数据
            2.读已提交：其他事务会读取当前事务已经提交的数据（也就是直接读取数据库中已经发生更改的内容）
            事务A 读取的是 事务B提交之后的数据，事务B在提交之前，事务A不可以读取数据
            3.可重复读：其他事务会读取当前事务已经提交的数据并且其他事务执行过程中不允许再进行数据修改（注意这里仅仅是不允许修改数据）
            事务A 读取的是 事务B提交之后的数据，但是事务A不能对数据进行修改
            4.串行化：它完全服从ACID原则，一个事务必须等待其他事务结束之后才能开始执行，相当于挨个执行，效率很低
        */

        ApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        SubjectService subjectService = context.getBean(SubjectService.class);
        subjectService.addSubject();
    }
}
