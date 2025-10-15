# 创建一张银行表
drop table if exists bank;
create table if not exists bank(
	id int primary key auto_increment,
	username varchar(50) not null,
	money float not null
);

# 向表中插入两条数据
insert into bank
values(1,'张三',10000),(2,'李四',5000);

select * from bank;

# 转账业务：张三需要转账2000给李四
# 注意：这一个业务包含了两条update语句
# 当一个业务中包含了多条件操作语句时，这语句要么全部执行，要么全部不执行，但凡有一条语句出错，就要回滚的最初状态
# 这个就是事务处理
# MySQL的事务默认是自动提交的，也就是说，每个条执行语句都是一个单独的事务，执行一天SQL语句隐式提交一次事务

# 我们现在要执行条件操作语句后才提交事务，就要把隐式提交关闭，改成显式提交
start transaction;   # 或者begin 都是改成显式提交事务
update bank set money=money-2000 where username='张三';
update bank set money=money+2000 where username='李四';

# 回滚事务，回到开启事务之前的状态
rollback;

# 提交事务，将开始事务之后的操作更新到数据库
commit;

/*
事务的四大特性（ACID）

原子性(Atomicity)
事务是不可分割的最小单元，要么全部成功，要么全部失败

一致性(Consistency)
事务完成时，必须使所有的数据都保持一致状态

隔离性(Lsolation)
数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行

持久性(Durability)
事务一旦提交或回滚，它对数据库中的数据的改变就是永久的
*/