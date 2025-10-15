# 直接查询整张表，底层是把数据库的所有数据页遍历一遍，将学生的信息筛选出来
select * from student;

# 学号是主键列，主键列默认会建成主键索引
# 这里根据学号查询，它是先到索引页，找到S1101001索引，在根据S1101001索引指向的数据页直接查找对应的数据
select * from student where studentNo='S1101001';

# 年级编号是外键，在创建外键时，会自动创建一个外键索引
# 所以根据年级编号查询数据，也是先查询索引页，再根据索引页中索引指向的数据页查询对应的数据
select * from student where gradeId=2;

# 注意：这里的姓名只是一个普通列，所以根据姓名查询，是遍历所有的数据页查询数据（性能肯定不高）
select * from student where studentName='姚恒';

# 当表中的字段比较多时，而且这些字段经常作为筛选条件去使用，这个时候就需要手动多创建几个索引

# 查看一张表中的索引
show index from student;

# 创建索引
# 这里是根据学生的姓名创建一个普通索引
# 注意：创建索引会增加大量数据库的存储空间
create index ix_studentName on student(studentName);

# 创建唯一索引，要求是对应的索引列不能有重复数据（其实主键索引同时也是唯一索引）
create UNIQUE index ix_subjectName on subject(subjectName);
show index from `subject`;
# 删除索引
drop index ix_subjectName on `subject`;

# 总结：
/*
	优点：
	索引提高了查询数据的速度，特别是在数据量较大的时候
	缺点：
	频繁创建索引会增加数据库的存储空间
	增删改操作的时间会增加，因为每次一次对数据的操作，都要更新索引页
*/
