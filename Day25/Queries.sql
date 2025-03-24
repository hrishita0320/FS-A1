71./* Write a SQL query to list employee names and department names for employees with a salary greater than 2000 using INNER JOIN.


+-------+------------+
| ename | dname      |
+-------+------------+
*/
USE test; 
select emp.ename,dept.dname from emp inner join dept on emp.deptno=dept.deptno where emp.sal>2000;

72./* Write a SQL query to retrieve all employees and their department locations, 
including those without departments, using LEFT JOIN.

+--------+----------+
| ename  | location |
+--------+----------+
*/
USE test; 
select emp.ename,dept.location from emp left join dept on emp.deptno=dept.deptno;

73./* Write a SQL query to list all department numbers, department names and their 
employee counts, including departments with no employees, using RIGHT JOIN.

+--------+------------+-----------+
| deptno | dname      | emp_count |
+--------+------------+-----------+
*/
USE test; 
select dept.deptno,dept.dname,count(emp.empno) as emp_count from emp right join dept on emp.deptno=dept.deptno group by dept.deptno;
74./* Write a SQL query to simulate a FULL OUTER JOIN to list all employees and 
departments, including unmatched rows.

+-------+--------+--------+------------+
| empno | ename  | deptno | dname      |
+-------+--------+--------+------------+
*/
USE test; 
select emp.empno,emp.ename,dept.deptno,dept.dname from emp left join dept on emp.deptno=dept.deptno union
select emp.empno,emp.ename,dept.deptno,dept.dname from emp right join dept on emp.deptno=dept.deptno;

75./* Write a SQL query to find employees who are managers of other employees using 
a self-join.

+---------+
| manager |
+---------+
*/
USE test; 
select distinct e1.ename as manager from emp e1 join emp e2 on e1.empno=e2.mgr;

76./* Write a SQL query to generate all possible employee-department combinations 
using CROSS JOIN.

+--------+------------+
| ename  | dname      |
+--------+------------+
*/
USE test; 
select emp.ename,dept.dname from dept cross join emp;
77./* Write a SQL query to list departments with employees earning more than 2500 
using EXISTS.

+--------+------------+
| deptno | dname      |
+--------+------------+
*/
USE test; 
select dept.deptno,dept.dname from dept where exists(select emp.empno from emp where emp.sal>2500 and emp.deptno=dept.deptno);
78./* Write a SQL query to find departments with number of employees earning less 
than 1000 using NOT EXISTS.

+------------+--------+
| dname      | deptno |
+------------+--------+
*/
USE test; 
select dept.dname,dept.deptno from dept where not exists(select emp.empno from emp where emp.sal<1000 and emp.deptno=dept.deptno);

79./* Write a SQL query to find managers and the number of employees they manage in
departments located in 'New York', using the primary key and foreign key 
constraints.

+--------------+-----------+
| manager_name | emp_count |
+--------------+-----------+
*/
USE test; 


USE test;

select e.ename as manager_name, COUNT(e1.empno) as emp_count from emp e join dept d on e.deptno = d.deptno join emp e1 on e.empno = e1.mgr
where d.location = 'New York' group by e.ename;

80./* Write a SQL query to list all employees and departments, including those 
without matches, using a simulated FULL JOIN.


+-------+--------+--------+------------+----------+
| empno | ename  | deptno | dname      | location |
+-------+--------+--------+------------+----------+
*/
USE test; 
select emp.empno,emp.ename,dept.deptno,dept.dname,dept.location from emp left join dept on emp.deptno=dept.deptno union 
select emp.empno,emp.ename,dept.deptno,dept.dname,dept.location from emp right join dept on emp.deptno=dept.deptno;
81./* Write a SQL query to list employee names and department names where the 
department is in 'Chicago' using INNER JOIN.

+-------+-------+
| ename | dname |
+-------+-------+
*/
USE test; 
select emp.ename,dept.dname from emp join dept on emp.deptno=dept.deptno where location ="Chicago" ;

82./* 
Retrieve Department-wise Total Salary and Number of Employees (Using GROUP BY and JOIN)

+------------+---------------+--------------+
| dname      | num_employees | total_salary |
+------------+---------------+--------------+

*/
USE test; 
select dept.dname,count(emp.empno) as num_employees,sum(emp.sal) as total_salary from emp right join dept on emp.deptno=dept.deptno group by dept.dname;

83./* Write a SQL query to list departments with no assigned employees using 
RIGHT JOIN.

+--------+---------+
| deptno | dname   |
+--------+---------+

*/
USE test; 
select dept.deptno,dept.dname from emp right join dept on emp.deptno=dept.deptno where empno is null;

84./* Write a SQL query to combine employee and department data with duplicates 
using UNION ALL.


+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE test; 
select emp.ename,dept.dname from emp left join dept on emp.deptno=dept.deptno union all select emp.ename,dept.dname from emp right join dept on emp.deptno=dept.deptno;
85./* Write a SQL query to list employees and their managers’ names using a LEFT 
JOIN for employees without managers.

+----------+---------+
| employee | manager |
+----------+---------+

*/
USE test; 
select e1.ename as employee,e2.ename as manager from emp e1 left join emp e2 on e1.mgr=e2.empno ;

86./* Write a SQL query to retrieve average salaries per department using INNER 
JOIN and GROUP BY.

+--------+------------+-------------+
| deptno | dname      | avg_salary  |
+--------+------------+-------------+

*/
USE test; 
select dept.deptno,dept.dname,avg(emp.sal) as avg_salary from emp join dept on emp.deptno=dept.deptno group by dept.deptno;

87./* Write a SQL query to find departments with more than 3 employees using 
INNER JOIN and HAVING.

+--------+----------+-----------+
| deptno | dname    | emp_count |
+--------+----------+-----------+

*/
USE test; 
select dept.deptno,dept.dname,count(emp.empno) as emp_count from emp join dept on emp.deptno=dept.deptno  group by dept.deptno having emp_count>3;

88./* Write a SQL query to list employees and departments where the employee’s 
hire date is after 1980 using INNER JOIN.

+--------+------------+------------+
| ename  | dname      | hiredate   |
+--------+------------+------------+
*/
USE test; 
select e.ename,d.dname,e.hiredate from emp e inner join dept d on e.deptno=d.deptno where e.hiredate>'1980-01-01';

89./* 
Find Departments Without Employees (Using LEFT JOIN and NULL Check)

+------------+----------+
| Department | Location |
+------------+----------+


*/
USE test; 
select dept.dname as Department,dept.location as Location from dept left join emp on emp.deptno=dept.deptno where emp.deptno is null;



90./* Write a SQL query to list employee names and department names using an
implicit join, ordered by employee name.

+--------+------------+
| ename  | dname      |
+--------+------------+

*/
USE test; 
select emp.ename,dept.dname from emp join dept on emp.deptno=dept.deptno order by emp.ename;