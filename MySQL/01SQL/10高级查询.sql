# 员工表
create table emp(
id int primary key auto_increment,
name varchar(20) not null
);

# 薪资表
create table salary(
id int primary key auto_increment,
empId int not null,
money float not null,
payDate datetime not null
);

# 关系
alter table salary 
add constraint fk_salary_emp foreign key(empId)
references emp(id);

#插入数据
insert into emp
values(1,'马云'),(2,'雷军');
select * from emp;

insert into salary
values
(1,1,10000,'2024-1-1'),
(2,1,12000,'2024-2-1'),
(3,1,13000,'2024-3-1'),
(4,1,14000,'2024-4-1'),
(5,1,15000,'2024-5-1'),
(6,1,16000,'2024-6-1'),
(7,1,17700,'2024-7-1'),
(8,1,18800,'2024-8-1'),
(9,1,21000,'2024-9-1'),
(10,1,20300,'2024-10-1'),
(11,1,20400,'2024-11-1'),
(12,1,12000,'2024-12-1'),
(13,2,13000,'2024-1-1'),
(14,2,14000,'2024-2-1'),
(15,2,15000,'2024-3-1'),
(16,2,16000,'2024-4-1'),
(17,2,17000,'2024-5-1'),
(18,2,18000,'2024-6-1'),
(19,2,19000,'2024-7-1'),
(20,2,18800,'2024-8-1'),
(21,2,19900,'2024-9-1'),
(22,2,21100,'2024-10-1'),
(23,2,10000,'2024-11-1'),
(24,2,10000,'2024-12-1');

insert into salary
values
(25,1,10000,'2025-1-1'),
(26,1,12000,'2025-2-1'),
(27,2,13000,'2025-1-1'),
(28,2,14000,'2025-2-1');
select * from salary;

# 查询马云2024年的工资
create view vw_mySalary2024
as
select name,payDate,money from salary
inner join emp on salary.empId=emp.id
where name='马云' and year(payDate)=2024;

# 现在的需求是这样的，要数据横向展示
# 姓名 一月 二月 三月 四月 五月 ..... 十二月
# 马云 100 200 300  400 500  ....  1200

select 
'马云' as 姓名,
(select money from vw_mySalary2024 where month(payDate)=1) as 一月,
(select money from vw_mySalary2024 where month(payDate)=2) as 二月,
(select money from vw_mySalary2024 where month(payDate)=3) as 三月,
(select money from vw_mySalary2024 where month(payDate)=4) as 四月,
(select money from vw_mySalary2024 where month(payDate)=5) as 五月;
