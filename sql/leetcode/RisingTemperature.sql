# Write your MySQL query statement below
select w.Id from Weather w where w.Temperature > 
(select w2.Temperature from Weather w2 where w2.Date = DATE_ADD(w.Date, INTERVAL -1 DAY))