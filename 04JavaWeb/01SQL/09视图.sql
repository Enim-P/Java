# 很多时候我们向数据请问数据，查询的内容是一样的，只是每次查询的条件不同
# 但是每次都要重复组织查询内容的SQL语句，代码相当冗余

select student.studentNo,studentName,sex,phone,studentResult,subjectName,examDate
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId
where student.studentNo='S1101001';

select student.studentNo,studentName,sex,phone,studentResult,subjectName,examDate
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId
where studentName like '%王%';

select student.studentNo,studentName,sex,phone,studentResult,subjectName,examDate
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId
where subjectName like '%数据库%';

# 通过视图简化上面的查询
# 创建视图可以通过管理工具直接创建，选择视图右键新建
# 视图建好后，就可以根据视图查询
select * from vw_studentResult;
# 查询视图本质上就是查询一个子查询
select * from (
	select student.studentNo,studentName,sex,phone,studentResult,subjectName,examDate
	from result inner join student on result.studentNo=student.studentNo
	inner join `subject` on result.subjectId=`subject`.subjectId
) as vw_studentResult

select * from vw_studentResult where studentNo='S1101001';

select * from vw_studentResult where studentName like '%王%';

select * from vw_studentResult where subjectName like '%数据库%';

# 删除视图
drop view vw_studentResult;

# 创建视图
create view vw_studentResult
as 
select student.studentNo,studentName,sex,phone,studentResult,subjectName,examDate
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId;


# 创建一个视图，存储每个年级的学生人数
create view vw_gradeStdentCount
as 
select count(*) as count,gradeName  from student 
inner join grade on student.gradeId=grade.gradeId
group by gradeName;

select * from vw_gradeStdentCount
order by count;

