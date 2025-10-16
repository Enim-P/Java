# DML(Data Manipulation Language)
#	数据操作语言，用来对数据库表中的数据进行增删改

# 使用myschool数据库
use myschool;

# 查询数据库下面的所有表
show tables;

# 查看指定表的结构
desc student;

# 返回建表语句
show create table student;

######################################
# 1.新增数据
# 往年级表添加数据
select * from grade;
insert into grade(gradeId,gradeName) values(1,'一年级');
# 年级编号是标识列，可以省略
insert into grade(gradeName) values('二年级');
# 可以一次性插入多条数据
insert into grade(gradeName) values('三年级'),('四年级');

# 往学生表添加数据
select * from student;
insert into student(studentNo,loginPwd,studentName,gender,bornDate,gradeId)
values('S1001','123456','张三','男','2011-1-1','1');
# 使用default关键字设置默认值
insert into student(studentNo,loginPwd,studentName,gender,bornDate,gradeId)
values('S1002','123456','李四',default,'2012-2-2','2');
# 可以省略列名，此时就必须按照列名的顺序插入数据
insert into student
values('S1003','123456','王五',default,'2013-3-3','3');

# 往课程表添加数据
select * from `subject`;
insert into `subject`(subjectName,classHour,gradeId)
values('语文',22,1),('数学',33,2),('英语',44,3)

# 往成绩表添加数据
select * from result;
insert into result(studentNo,subjectId,studentResult,examDate)
values('S1001',1,66,'2022-2-2'),('S1002',2,77,'2022-3-2'),('S1003',3,88,'2022-4-2');

# 2.修改数据
# 修改语句不加条件是修改整张表
update student set studentName='张杰',loginPwd='112233',bornDate='1999-9-9' 
where studentNo='S1001';

# 将小于60分的成绩改成60分
update result set studentResult=60 where studentResult<60;

# 所有科目的课时增加10
update `subject` set classHour=classHour+10;

# 3.删除数据
# 删除指定成绩编号的成绩
delete from result where resultId=3;

# 删除指定的学生
# 要先删除学生的成绩，再删除该学生
delete from result where studentNo='S1001';
delete from student where studentNo='S1001';

# 删除指定的年级
# 删除关联的成绩
delete from result where studentNo in (
	select studentNo from student where gradeId=2
);
delete from result where subjectId in (
	select subjectId from `subject` where gradeId=2
);
# 删除年级对应的学生
delete from student where gradeId=2;
# 删除年级对应的课程
delete from `subject` where gradeId=2;
# 最后删除对应的年级
delete from grade where gradeId=2;

# 删除所有成绩
delete from result;

# 格式化整张表
truncate table result;

# 注意：不加条件的删除语句跟格式化整张表的效果是一样的
# 区别是：删除语句保留标识列当前序号，格式化语句不保留
# 比如当前标识列的序号到5，删除所有的数据后，再插入新的数据，标识列为6。而格式化为1

# 注意2：不加条件的删除语句是非常危险的，其实在企业开发中，删除语句通常都是修改语句做假删除
# 我们会在表中添加一个标记，比如：isDel，默认值是false，设置为true表示删除。




