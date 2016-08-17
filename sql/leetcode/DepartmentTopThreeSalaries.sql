# Write your MySQL query statement below
select d.Name as Department, e.Name as Employee, Salary as Salary
from Employee e inner join Department d on e.DepartmentId = d.Id 
where (select count(distinct (e2.salary)) 
       from Employee e2 
       where e2.DepartmentId = e.DepartmentId and e2.Salary > e.Salary) < 3
order by DepartmentId, Salary desc, e.Name

