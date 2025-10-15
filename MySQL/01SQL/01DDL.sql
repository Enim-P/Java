/*
	SQL分类：
	1.DDL(Data Definition Language)
	数据定义语言，用来定义数据库对象（数据库，表，字段）
	2.DML(Data Manipulation Language)
	数据操作语言，用来对数据库表中的数据进行增删改
	3.DQL(Data Query Language)
	数据查询语言，用来查询数据库中表的记录
	4.DCL(Data Control Language)
	数据控制语言，用来创建数据库用户、控制数据库的访问权限
*/

# DDL
# 查看所有数据库
show databases;

# 查看当前数据库
select database();

# 使用指定的数据库
use myschool;

# 创建数据库
create database myschool;
# 创建数据库并判断数据库是否不存在
create database if not exists myschool;

# 删除数据库
drop database myschool;
# 删除数据库并判断数据库是否存在
drop database if exists myschool;

# 表操作（创建、查询、修改、删除）
# 创建表
create table if not exists grade(
	gradeId int primary key auto_increment comment '年级编号',
	gradeName varchar(50) not null comment '年级名称'
)comment '年级表';

# 删除表
drop table if exists grade;

# 创建学生表
drop table student;
create table student(
	studentNo varchar(50) primary key comment '学号',
	loginPwd varchar(50) not null comment '密码',
	studentName varchar(20) not null comment '姓名',
	sex varchar(2) not null default '男' comment '性别',
	bornDate datetime not null comment '生日',
	gradeId int not null comment '年级编号'
)comment '学生表';

# 添加字段
alter table student 
add email varchar(50) null comment '邮箱';

# 修改字段的类型
alter table student modify loginPwd varchar(100);

# 修改字段名和字段类型
alter table student change sex gender varchar(2) 
DEFAULT '女' comment '性别';

# 删除字段
alter table student drop column email;

# 修改表名
rename table xuesheng to student;

# 创建学生表和年级表的主外键关系
alter table student 
add constraint fk_student_grade foreign key(gradeId)
references grade(gradeId);

# 删除主外键关系
alter table student
drop constraint fk_student_grade;

# 创建课程表
drop table if exists `subject`;
create table if not exists `subject`(
	subjectId int primary key auto_increment comment '课程编号',
	subjectName varchar(200) not null comment '课程名称',
	classHour int not null comment '课时',
	gradeId int not null comment '年级编号',
	# 在创建表的同时将外键也设置好
  foreign key(gradeId) references grade(gradeId)
)comment '课程表';

# 创建成绩表
drop table if exists result;
create table if not exists result(
	resultId int primary key comment '成绩编号',
	studentNo varchar(50) not null comment '学号',
	subjectId int not null comment '课程编号',
	examDate datetime not null comment '考试日期',
	studentResult int not null comment '考试成绩',
	# 设置成绩表的外键关系
	foreign key(studentNo) references student(studentNo),
	foreign key(subjectId) references `subject`(subjectId)
)comment '成绩表';
# 注意：成绩表中的学号的长度必须跟学生表中学号的长度一直，否则无法创建外键关系
# 主外键关系的两个列的类型、长度必须完全一致


# 数据类型分析
# int       整型
# bigint    长整型
# smallint  短整型
# varchar   可变长度字符型，比如：varchar(20)它的存储空间是0-20
# char      固定长度字符型，比如：char(20)只要存数据就是20
# text      无限长度字符型，比如：存储一遍文章的数据
# datetime  日期+时间，注意：mysql的时间只到秒
# date      日期
# time      时间
# timestamp 时间戳，距离1970-01-01的毫秒数，负数是往前
# float     浮点型
# double    双精度浮点型
# decimal   控制长度和精度的浮点型，比如使用decimal(10,2)存金额数据







