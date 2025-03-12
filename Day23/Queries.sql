21.
/* Find employees who earn more than the average salary of all employees.

Expected Output Columns:
------------------------
+-------+---------+
| ename | sal     |
+-------+---------+

*/
USE test;
select ename,sal from emp where sal>(select avg(sal) from emp);



22.
/* Find the name and salary of the highest-paid employee.

Expected Output Columns:
------------------------
+-------+---------+
| ename | sal     |
+-------+---------+

*/
USE test;
select ename,sal from emp where sal = (select max(sal) from emp) limit 1;




23.
/* Find employees who earn more than the highest-paid employee in department 10.

Expected Output Columns:
------------------------
+-------+---------+--------+
| ename | sal     | deptno |
+-------+---------+--------+

*/
USE test;
select ename,sal,deptno from emp where sal >(select max(sal) from emp where deptno=10);



24./* Find employees whose salary is higher than the salary of ‘SCOTT’.

Expected Output Columns:
------------------------
+-------+---------+
| ename | sal     |
+-------+---------+

*/
USE test;
select ename,sal from emp where sal>(select sal from emp where ename='SCOTT');


25.
/* Find employee who have the same job title as 'FORD'.

Expected Output Columns:
------------------------
+-------+---------+
| ename | job     |
+-------+---------+

*/
USE test;
select ename,job from emp where job IN (select job from emp where ename='FORD');





26.
/* Find departments that have at least one employee earning more than 3000.

Expected Output Columns:
------------------------
+--------+------------+
| deptno | dname      |
+--------+------------+

*/
USE test;
select deptno,dname from dept where deptno IN (select deptno from emp where sal>3000 group by deptno);




27.
/* Find employees who were hired before all employees in department 30.

Expected Output Columns:
------------------------
+-------+------------+
| ename | hiredate   |
+-------+------------+

*/
USE test;
select ename,hiredate from emp where hiredate < (select min(hiredate) from emp where deptno=30);




28.
/* Find employees who belong to departments located in 'Dallas'.

Expected Output Columns:
------------------------
+-------+--------+
| ename | deptno |
+-------+--------+

*/
USE test;
select ename,deptno from emp where deptno IN (select deptno from dept where location = 'DALLAS');




29.
/* Find the second highest salary from employees.

Expected Output Columns:
------------------------
+-----------------------+
| second_highest_salary |
+-----------------------+

*/
USE test;
select max(sal) as second_highest_salary from emp where sal<(select max(sal) from emp);



30.
/* Find employees who have the same manager as ‘BLAKE’.

Expected Output Columns:
------------------------
+-------+------+
| ename | mgr  |
+-------+------+

*/
USE test;
select ename,mgr from emp where mgr = (select mgr from emp where ename = 'BLAKE' ) and ename!='BLAKE';



31./* Find employees who belong to a department with no employees.

Expected Output Columns:
------------------------
+---------+
| dname   |
+---------+

*/
USE test;
select dname from dept where deptno not in(select deptno from emp);
32./* Find the department that has the most employees.

Expected Output Columns:
------------------------
+--------+----------------+
| deptno | employee_count |
+--------+----------------+

*/
USE test;
select deptno,count(ename) as employee_count from emp group by deptno order by count(ename) desc limit 1;
33./* Find the department name where ‘JONES’ works.

Expected Output Columns:
------------------------
+----------+
| dname    |
+----------+

*/
USE test
select dname from dept where deptno=(select deptno from emp where ename="JONES" );
34./* Write a SQL query to find employees whose name contains ‘A’.

Expected Output Columns:
------------------------
+--------+-------+
| ename  | empno |
+--------+-------+

*/
USE test;
select ename,empno from emp where ename like "%A%";
35./* Retrieve employees who have a commission greater than their salary.

Expected Output Columns:
------------------------
+--------+-------+---------+---------+
| ename  | empno | sal     | comm    |
+--------+-------+---------+---------+

*/
USE test;
select ename,empno,sal,comm from emp where comm>sal;
36./* Write a SQL query to find all employees who do not receive a commission.

Expected Output Columns:
------------------------
+-------+-------+------+
| ename | empno | comm |
+-------+-------+------+

*/
USE test;
select ename,empno,comm from emp where comm is null or comm='0';
37./* Write a SQL query to count the number of employees who have a manager.

Expected Output Columns:
------------------------
+------------------------+
| employees_with_manager |
+------------------------+

*/
USE test;
select count(ename) as employees_with_manager from emp where mgr is not null;
38./* Write a SQL query to find the difference between the highest and second highest salary.

Expected Output Columns:
------------------------
+-------------------+
| salary_difference |
+-------------------+

*/
USE test;
select max(sal)-(select max(sal) from emp where sal not in(select max(sal) from emp)) as salary_difference from emp;
39./* Write a SQL query to calculate the total salary and total commission for all employees.

Expected Output Columns:
------------------------
+--------------+------------------+
| Total Salary | Total Commission |
+--------------+------------------+

*/
USE test;
select sum(sal) as 'Total Salary' , sum(comm) as 'Total Commission' from emp;
40./* Write a SQL query to calculate the average salary and average commission of employees.

Expected Output Columns:
------------------------
+----------------+--------------------+
| Average Salary | Average Commission |
+----------------+--------------------+

*/
USE test;
select avg(sal) as 'Average Salary',avg(comm) as 'Average Commission' from emp;


41./* Write a SQL query to calculate the average salary of employees with a commission.

Expected Output Columns:
------------------------
+----------------------+
| avg_salary_with_comm |
+----------------------+

*/
USE test;
select avg(sal) as 'avg_salary_with_comm' from emp where comm IS NOT NULL;

42./* Write a SQL query to determine the minimum commission value, excluding NULLs.

Expected Output Columns:
------------------------
+----------------+
| min_commission |
+----------------+

*/
USE test;
select MIN(comm) as min_commission from emp where comm IS NOT NULL;

43./* Write a SQL query to find the total commission paid to employees hired after 1995.

Expected Output Columns:
------------------------
+----------------------+
| total_comm_post_1995 |
+----------------------+

*/
USE test;
select sum(comm) as 'total_comm_post_1995' from emp where YEAR(hiredate)>1995;

44./* Write a SQL query to find the maximum hire date (latest hire) in the emp table.

Expected Output Columns:
------------------------
+-------------+
| latest_hire |
+-------------+

*/
USE test;
select MAX(hiredate) as latest_hire from emp;

45./* Write a SQL query to find the average commission for salesmen, excluding NULLs.

Expected Output Columns:
------------------------
+-------------------+
| avg_salesman_comm |
+-------------------+

*/
USE test;
select avg(comm) as avg_salesman_comm from emp where job="SALESMAN" and comm is not null;

46./* Write a SQL query to determine the minimum salary for employees hired in the 1990s.

Expected Output Columns:
------------------------
+----------------+
| min_salary_90s |
+----------------+

*/
USE test;
select MIN(sal) as min_salary_90s from emp where YEAR(hiredate) between 1990 and 1999;

47./* Write a SQL query to find the total salary of employees whose names start with 'K'.

Expected Output Columns:
------------------------
+----------------+
| total_salary_k |
+----------------+

*/
USE test;
select SUM(sal) as total_salary_k from emp where ename LIKE 'K%';

48./* Write a SQL query to count the number of employees hired in each year.

Expected Output Columns:
------------------------
+-----------+----------------+
| hire_year | hires_per_year |
+-----------+----------------+

*/
USE test;
select YEAR(hiredate) as hire_year,COUNT(hiredate) as hires_per_year from emp group by YEAR(hiredate);

49./* Write a SQL query to sum the commissions for employees with salaries below 1500.

Expected Output Columns:
------------------------
+-----------------------+
| total_comm_low_salary |
+-----------------------+

*/
USE test;
select SUM(comm) as total_comm_low_salary from emp where sal<1500;

50./* List employees who do not receive a commission but earn more than 2500.

Expected Output Columns:
------------------------
+-------+---------+------+
| ename | sal     | comm |
+-------+---------+------+

*/
USE test;
select ename,sal,comm from emp where sal>2500 and comm IS NULL;