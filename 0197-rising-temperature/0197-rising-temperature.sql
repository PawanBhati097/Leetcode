# Write your MySQL query statement below
SELECT W.id 
FROM Weather AS W
 JOIN Weather AS E 
 ON DATEDIFF(W.recordDate, E.recordDate) = 1
 WHERE w.temperature>E.temperature;