# 子查询：就是在一个完整的查询语句中包含另一个完整的查询
# 子查询可以以任何形式出现，包括：条件，表，列，行，大部分情况下以条件的形式出现比较多

# 查询大二年级的学生信息
# 方式一：表连接
select studentNo,studentName,gradeName from student
inner join grade on student.gradeId = grade.gradeId
where gradeName='大二';
# 方式二：多表查询
select studentNo,studentName,gradeName from student,grade
where student.gradeId=grade.gradeId and gradeName='大二';
# 上面两种方式适合从两张表中查询出综合数据
# 如果只需要从一张表中查询出需要的数据，也可以使用子查询（这个查询是作为条件存在的）
select studentNo,studentName
from student
where gradeId=(
	select gradeId from grade where gradeName='大二'
);

# 查询大二年级所有的成绩信息
# 方式一：表连接（从三张表中查询综合数据）
select student.studentNo,studentName,gradeName,studentResult from result
inner join student on result.studentNo=student.studentNo
inner join grade on student.gradeId=grade.gradeId
where gradeName='大二';
# 方式二：子查询（在查询成绩表中的数据）
select * from result
where studentNo in (   # 因为子查询返回的结果不止一个，所以使用in
	select studentNo from student
	where gradeId = (
		select gradeId from grade where gradeName='大二'
	)
);
# 子查询可以无限嵌套，它的执行顺序是先执行子查询再执行父查询，也就是从内往外执行

# 子查询作为列存在的情况（了解）
select studentNo,(select studentName from student where studentNo=result.studentNo) as studentName,
studentResult
from result

# 子查询作为表存在的情况（了解）
select studentNo,studentName,bornDate from (
	select * from student
	where sex='男'
) as student2

# 查询大二年级年龄最大的学生信息
select * from student
where gradeId=(
	select gradeId from grade where gradeName='大二'
)
order by bornDate asc
limit 1;

# 查询“使用C#语言开发数据库应用系统”最近一次的考试信息
select * from result 
where subjectId=(
	select subjectId from `subject`
	where subjectName='使用C#语言开发数据库应用系统'
) and examDate=(
	select max(examDate) from result
	where subjectId=(
		select subjectId from `subject`
		where subjectName='使用C#语言开发数据库应用系统'
	)
);



