select e.Name as Employee from Employee e inner join Employee m on e.ManagerId = m.Id
where m.Salary < e.Salary