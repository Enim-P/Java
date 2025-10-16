# DQL：Data Query Language（数据查询语言）

use myschool;

# 查询整张表的所有字段
select * from student;

# 查询指定列的数据
select studentNo,studentName,sex,phone from student;

# 设置列的别名
select studentNo as 学号,studentName as 姓名,sex as 性别,phone as 电话 from student;
# as可以省略
select studentNo 学号,studentName 姓名,sex 性别,phone 电话 from student;

# 去重查询
select distinct studentNo from result;

# 带条件查询
# 通过where语句设置查询条件
select * from student where studentNo='S1101001';

# where语句的条件通常需要通过比较运算符判断
# SQL中的比较运算符包括：
/*
	>         大于
	>=        大于等于
	<         小于
	<=        小于等于
	=         等于
	!=、<>    不等于
	between ... and ...      在某个范围之内(包含最小值、最大值)
	in(...)                  在指定的列表范围内（多选一）
	like 占位符               模糊匹配（通配符：_匹配单个字符，%匹配任意字符）
	is null、is not null     null判断     
*/
# SQL中的逻辑运算符
/*
	add       并且（多个条件同时成立）
	or        或者（多个条件任意一个成立）
	not       非（取反）
*/

# 查询成绩表中大于80分的成绩
select * from result where studentResult>80;

# 查询成绩表中大于等于80分的成绩
select * from result where studentResult>=80;

# 查询成绩表中不等于80分的成绩
select * from result where studentResult!=80;  # 推荐写法
select * from result where studentResult<>80;
# 写法二
select * from result where not(studentResult=80)
# not也可以改成!符号
select * from result where !(studentResult=80)

# 查询成绩在60分到80分之间的信息
select * from result where studentResult between 60 and 80;
# 写法二
select * from result where studentResult>=60 and studentResult<=80;
# and 可以写成&& 建议还是使用and，&&兼容性不高
select * from result where studentResult>=60 && studentResult<=80;

# 查询成绩正好为（60、70、80、90、100）的信息
select * from result where studentResult in (60,70,80,90,100);
# 写法二
# or 也可以还有||符号，推荐还是使用or
select * from result 
where studentResult=60 or studentResult=70 or studentResult=80
or studentResult=90 or studentResult=100;

# 查询课时为null的课程信息 
select * from `subject` where classHour is null;

# 查询姓王的单名学生信息
select * from student where studentName like '王_';
# 查询姓王的学生信息
select * from student where studentName like '王%';
# 查询课程名称中包含“数据库”的课程信息
select * from `subject` where subjectName like '%数据库%';
# concat()    函数用于拼接字符串
select * from `subject` where subjectName like concat('%','系统','%');


# DQL - 排序查询
# 根据成绩升序（默认的排序规则就是升序，所以asc可以省略）
select * from result where subjectId=1
order by studentResult asc
# 根据成绩降序
select * from result where subjectId=1
order by studentResult desc

# 先根据课程编号升序，再根据成绩降序
select * from result
order by subjectId asc,studentResult desc;

# DQL - 分页查询
# 返回前5条数据
select * from result
limit 5;

# 返回第11条到第15条数据
# 这里的10是先跳过前面的10条数据，再返回后面的5条数据
select * from result
LIMIT 10,5

