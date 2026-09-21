# Write your MySQL query statement below
SELECT name
 from Customer
 WHERE
 IFNULL(referee_id,0) <> 2;
-- where referee_id !=2 OR referee_id IS NULL;