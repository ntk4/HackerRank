# Write your MySQL query statement below
select s.Score , (select count(distinct s1.score) from Scores s1 where s1.Score > s.Score) + 1 as Rank
from Scores s
order by s.Score desc