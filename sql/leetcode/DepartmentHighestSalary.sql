# Write your MySQL query statement below
select d.Name as Department, e.Name as Employee, e.Salary
from Employee e inner join Department d on d.id = e.DepartmentId
where e.Salary = (select max(e2.salary) from Employee e2 where e2.departmentId = e.departmentId)
order by Department