# Write your MySQL query statement below
SELECT MAX(e1.salary) AS SecondHighestSalary
FROM Employee e1 INNER JOIN Employee e2
ON e1.salary <e2.salary