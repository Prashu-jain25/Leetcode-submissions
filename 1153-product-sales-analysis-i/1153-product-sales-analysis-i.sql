# Write your MySQL query statement below
SELECT product.product_name, Sales.year, Sales.price
FROM Sales
JOIN product ON Sales.product_id = product.product_id;