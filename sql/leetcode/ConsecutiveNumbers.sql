select distinct l.Num as ConsecutiveNums from Logs l, Logs l1, Logs l2 
where l.Id = l1.Id - 1 and l1.Id = l2.Id - 1
and l.Num = l1.Num and l1.Num = l2.Num


#Solution 2
SELECT DISTINCT(Num) AS ConsecutiveNums
FROM (
    SELECT
    Num,
    @counter := IF(@prev = Num, @counter + 1, 1) AS how_many_cnt_in_a_row,
    @prev := Num
    FROM Logs y, (SELECT @counter:=1, @prev:=NULL) vars
) sq
WHERE how_many_cnt_in_a_row >= 3