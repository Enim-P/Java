# 聚合函数：用于对数据列做计算统计
/*
	count        统计数量
	max          统计最大值
	min          统计最小值
	avg          统计平均值
	sum          统计求和
*/

# 统计学生的数量
# *号是统计数据行数
select count(*) from student;
# 统计参加考试的学生数量
# count函数，可以根据指定的列统计，表示统计该列不为null的函数，配合distinct就表示去重复统计
select count(distinct studentNo) from result;

# 统计姚恒的总分，平均分，最高分，最低分
select count(studentResult) as 考试次数,
sum(studentResult) as 总成绩,avg(studentResult) as 平均分,
max(studentResult) as 最高分,min(studentResult) as 最低分
 from result 
inner join student on result.studentNo=student.studentNo
where studentName='姚恒'

# 统计大二年级的总分和平均分
select sum(studentResult) as 总成绩,avg(studentResult) as 平均分
from result inner join student on result.studentNo=student.studentNo
inner join grade on student.gradeId=grade.gradeId
where gradeName='大二';

# 分组查询：就是对聚合查询的结果再做分组，在分组查询中只能查询聚合函数列和分组列
# 统计每个年级的学生人数
select count(*),gradeName from student
inner join grade on student.gradeId=grade.gradeId
group by gradeName;

# 统计每个年级男生和女生各多少人
select gradeName,sex,count(*) as 人数 from student
inner join grade on student.gradeId=grade.gradeId
group by gradeName,sex
order by gradeName asc,count(*) desc;

# 统计四月份出生的学生人数
/*
	now()     返回当前日期
	datediff(日期1,日期2)      返回两个日期间隔的天数
	year(日期)    返回日期的年份
	month(日期)   返回日期的月份
	day(日期)     返回的月的天数
*/
select count(*) from student
where month(bornDate)=4

# 统计考试人数超过15人的科目名称
# having语句是对分组后的结果做筛选
select count(*),subjectName
from result inner join `subject` on result.subjectId=`subject`.subjectId
group by subjectName
having count(*)>15

# 统计学生及格的平均分超过80分的最高的前三个人，返回学生姓名和平均分
select studentName,avg(studentResult) from result
inner join student on result.studentNo=student.studentNo
where studentResult>=60   #分组前筛选
group by studentName
having avg(studentResult)>80   #分组后筛选
order by avg(studentResult) desc
limit 3;

# 统计没有参加考试的学生人数最多的那个年级，返回年级名称，学生人数
select count(*),gradeName
from result right join student on result.studentNo=student.studentNo
inner join grade on student.gradeId=grade.gradeId
where studentResult is null
group by gradeName
order by count(*) desc 
limit 1;




