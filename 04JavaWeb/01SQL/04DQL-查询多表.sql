# 从多张表中查询出综合数据

# 内连接查询(inner join)：查询出两张表交集部分的数据

# 查询返回学生的姓名，性别，年级名称
# 学生表是没有年级名称，只有年级编号，年级表有年级名称
# 用学生表关键年级表一起查询，关键的条件是当学生的年级表=年级表的年级编号时，返回对应的年级名称
select studentName,sex,gradeName from student
inner join grade on student.gradeId=grade.gradeId
# 还可以使用多表查询
select studentName,sex,gradeName from student,grade
where student.gradeId=grade.gradeId;

# 查询学生姓名，考试成绩，考试科目名称
select studentName,studentResult,subjectName
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId;
# or
select studentName,studentResult,subjectName
from result,student,`subject`
where result.studentNo=student.studentNo and result.subjectId=`subject`.subjectId;

# 查询学生姓名，考试成绩，考试科目名称，学生所属年级名称
select studentName,studentResult,subjectName,gradeName
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId
inner join grade on student.gradeId=grade.gradeId;

# 查询学生姓名，考试成绩，考试科目名称，课程所属年级名称
select studentName,studentResult,subjectName,gradeName
from result inner join student on result.studentNo=student.studentNo
inner join `subject` on result.subjectId=`subject`.subjectId
inner join grade on `subject`.gradeId=grade.gradeId;

# 外连接查询（left join 和 right join）
# left join：查询出两张表交集部分的数据 + 左表剩余的数据
# right join：查询出两张表交集部分的数据 + 右表剩余的数据

# 查询学生姓名，性别，成绩
# 学生表和成绩表的关系，学生表是主表，成绩表是从表
# 主表放在左外连接的左边，或者放在右外连接的右边，表示主表里面的所有数据都返回
# 主表的全部数据都返回了，可能会存在跟从表不交集的数据，这些数据就返回null
select studentName,sex,studentResult
from student left join result
on result.studentNo=student.studentNo
# or
select studentName,sex,studentResult
from result right join student
on result.studentNo=student.studentNo

# 查询从来没有参加过考试的学生信息
select studentName,sex,studentResult
from student left join result
on result.studentNo=student.studentNo
where studentResult is null;

# 查询没有学生的年级
select gradeName from grade
left join student on grade.gradeId=student.gradeId
where studentName is null;

# 总结：当我们需要查询两张表里面不关联的数据时，通常会使用外连接



