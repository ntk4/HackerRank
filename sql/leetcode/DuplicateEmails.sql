# Write your MySQL query statement below
select distinct p.Email from Person p where p.Email in (select p2.Email from Person p2 where p2.Id <> p.Id)