package com.example.remedialucp2_077.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CategoryDao {

    @Query("""
    WITH RECURSIVE subcats(id) AS (
        SELECT id FROM Category WHERE id = :categoryId
        UNION ALL
        SELECT c.id FROM Category c
        JOIN subcats s ON c.parentId = s.id
    )
    SELECT * FROM Book
    WHERE id IN (
        SELECT bc.bookId FROM BookCategory bc
        WHERE bc.categoryId IN (SELECT id FROM subcats)
    )
    """)
    suspend fun getBooksRecursive(categoryId: Long): List<Book>

    @Query("UPDATE Category SET isDeleted = 1 WHERE id = :id")
    suspend fun softDeleteCategory(id: Long)
}