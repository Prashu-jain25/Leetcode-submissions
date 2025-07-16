# Write your MySQL query statement below
SELECT name FROM Customer WHERE referee_id IS NULL OR referee_id <> 2;

# Any comparison with NULL results in UNKNOWN 
# isliye null ke liye alg se check kia.