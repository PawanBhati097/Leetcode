# Write your MySQL query statement below
SELECT E.name 
FROM Employee e
INNER JOIN Employee em
ON e.id=em.managerId
 GROUP BY em.managerId
HAVING COUNT(em.managerId)>=5