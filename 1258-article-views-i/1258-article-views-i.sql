# Write your MySQL query statement below
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;

/*
 What This Query Does:

FROM Views: Use the Views table.
WHERE author_id = viewer_id: Only rows where the person who viewed is also the author.
SELECT DISTINCT author_id: Get unique author_ids from those rows.
ORDER BY author_id: Sort the result in ascending order.

*/