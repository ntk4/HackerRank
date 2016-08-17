# Write your MySQL query statement below
select t.Request_at as Day, 
round(sum(case when t.Status = 'completed' then 0 else 1 end)/count(*),2) as "Cancellation Rate"
from Trips t inner join Users c on t.Client_Id = c.Users_Id and c.Banned = 'No' and c.Role = 'client'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at