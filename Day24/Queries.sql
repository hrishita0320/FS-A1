51.
/*  Write a SQL query to find the average salary and number of employees per department, 
ordered by average salary in descending order.

Expected Output Columns:
------------------------
+--------+-------------+----------+
| deptno | AVG(sal)    | COUNT(*) |
+--------+-------------+----------+

*/
USE test; 
select deptno,AVG(sal), COUNT(*) from emp group by deptno order by avg(sal) desc;


52./*  Write a SQL query to list the total salary and employee count per job, 
excluding clerks.

+-----------+----------+----------+
| job       | SUM(sal) | COUNT(*) |
+-----------+----------+----------+

*/
USE test; 
select job, SUM(sal), COUNT(*) from emp where job!="CLERK" group by job;




53.
/*  Write a SQL query to show the total salary per department where the 
total salary exceeds 5000, ordered by department number.

+--------+----------+
| deptno | SUM(sal) |
+--------+----------+

*/
USE test; 
select deptno,SUM(sal) from emp group by deptno having sum(sal)>5000 order by deptno;




54.
/*  Write a SQL query to display the number of employees per job, sorted by job 
title alphabetically.

+-----------+----------+
| job       | COUNT(*) |
+-----------+----------+

*/
USE test; 
select job, COUNT(*) from emp group by job order by job;





55.
/*  Write a SQL query to find the minimum and maximum salaries per department, 
excluding department 20.

+--------+----------+----------+
| deptno | MIN(sal) | MAX(sal) |
+--------+----------+----------+

*/
USE test; 
select deptno, MIN(sal),MAX(sal) from emp where deptno!=20 group by deptno;





56.
/*  Write a SQL query to list departments with more than 3 employees, ordered 
by total salary descending.

+--------+----------+----------+
| deptno | SUM(sal) | COUNT(*) |
+--------+----------+----------+

*/
USE test; 
select deptno,SUM(sal),COUNT(*) from emp group by deptno having count(*)>3 order by sum(sal) desc;






57.
/* Write a SQL query to show the total commission and average salary per job 
for jobs with at least 2 employees.

+----------+-----------+-------------+
| job      | SUM(comm) | AVG(sal)    |
+----------+-----------+-------------+

*/
USE test; 
select job, SUM(comm), AVG(sal) from emp group by job having count(*)>=2;





58.
/* Write a SQL query to retrieve employees ordered by hire date and salary 
in descending order.

+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+

*/
USE test; 
select * from emp order by hiredate,sal desc;




59.
/* Write a SQL query to find the total salary per department and job
combination, excluding the president job.

+--------+----------+----------+
| deptno | job      | SUM(sal) |
+--------+----------+----------+

*/
USE test; 
select deptno,job,SUM(sal) from emp where job!="PRESIDENT" group by deptno,job;





60.
/* Write a SQL query to list departments with an average salary above 2000, 
ordered by average salary.

+--------+-------------+
| deptno | AVG(sal)    |
+--------+-------------+

*/
USE test; 
select deptno, AVG(sal) from emp group by deptno having AVG(sal)>2000;




61.
/* Write a SQL query to display the employee count and total salary per 
department for departments with total salary over 4000.

+--------+----------+----------+
| deptno | COUNT(*) | SUM(sal) |
+--------+----------+----------+

*/
USE test; 
select deptno,COUNT(*), SUM(sal) from emp group by deptno having sum(sal)>4000;





62.
/* Write a SQL query to show all employees sorted by department number and then
by job title alphabetically.


+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+

*/
USE test; 
select * from emp order by deptno,job;






63.
/* Write a SQL query to find the average salary per job in departments other
than 10, ordered by job.


+-----------+-------------+
| job       | AVG(sal)    |
+-----------+-------------+
*/
USE test; 
select job,AVG(sal) from emp where deptno!=10 group by job order by job;




64.
/* Write a SQL query to list the total salary and employee count per department, 
excluding employees named 'FORD'.


+--------+----------+----------+
| deptno | SUM(sal) | COUNT(*) |
+--------+----------+----------+
*/
USE test; 

select deptno,SUM(sal),COUNT(*) from emp where ename!="FORD" group by deptno;




65.
/* Write a SQL query to retrieve the total salary per job where the total salary 
is less than 10000, ordered by total salary descending.

+-----------+----------+
| job       | SUM(sal) |
+-----------+----------+
*/
USE test; 
select job,SUM(sal) from emp group by job having SUM(sal)<10000 order by sum(sal) desc;



66./* Write a SQL query to show employees ordered by salary descending and then by 
employee name ascending.

+-------+--------+-----------+------+------------+---------+---------+--------+
| empno | ename  | job       | mgr  | hiredate   | sal     | comm    | deptno |
+-------+--------+-----------+------+------------+---------+---------+--------+
*/
USE test; 
select * from emp order by sal desc ,ename

67./* Write a SQL query to find the maximum salary and employee count per department 
for departments with more than 2 employees.

+--------+----------+----------+
| deptno | MAX(sal) | COUNT(*) |
+--------+----------+----------+
*/
USE test; 
select deptno,MAX(sal),COUNT() from emp group by deptno having count()>2;

68./* Write a SQL query to list the total commission per department, excluding 
department 40, ordered by total commission.

+--------+-----------+
| deptno | SUM(comm) |
+--------+-----------+
*/
USE test; 
select deptno,SUM(comm) from emp where deptno!=40 group by deptno order by sum(comm);


69./* Write a SQL query to display the average salary and job count per department, 
sorted by department number and average salary descending.


+--------+-------------+------------+
| deptno | AVG(sal)    | COUNT(job) |
+--------+-------------+------------+
*/
USE test; 
select deptno,avg(sal),count(job) from emp group by deptno order by deptno,avg(sal) desc;


70./* Write a SQL query to find departments with a total salary greater than 3000,
excluding salesmen, ordered by total salary.


+--------+----------+
| deptno | SUM(sal) |
+--------+----------+
*/
USE test; 
select deptno,sum(sal) from emp where job!="SALESMAN" group by deptno having sum(sal)>3000 order by sum(sal);