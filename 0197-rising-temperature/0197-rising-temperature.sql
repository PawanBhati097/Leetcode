# Write your MySQL query statement below
SELECT W.id 
FROM Weather AS W
INNER JOIN Weather AS E 
 WHERE DATEDIFF(W.recordDate, E.recordDate) = 1
 AND w.temperature>E.temperature;