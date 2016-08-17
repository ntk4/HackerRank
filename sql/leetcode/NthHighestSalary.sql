CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select max(e.Salary) from Employee e
      where (select count(distinct(e1.Salary)) from Employee e1 where e1.Salary > e.Salary) = n - 1
      
  );
END