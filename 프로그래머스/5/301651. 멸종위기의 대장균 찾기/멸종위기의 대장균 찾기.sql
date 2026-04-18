WITH RECURSIVE g AS (
    SELECT id, parent_id, 1 AS generation
    FROM ECOLI_DATA
    WHERE parent_id IS NULL

    UNION ALL

    SELECT e.id, e.parent_id, g.generation + 1
    FROM ECOLI_DATA e
    JOIN g ON e.parent_id = g.id
)
SELECT COUNT(*) AS count, generation
FROM g
LEFT JOIN ECOLI_DATA child ON child.parent_id = g.id
WHERE child.id IS NULL
GROUP BY generation
ORDER BY generation;