package com.example.remedialucp2_077.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Insert
    suspend fun insert(book: Book)

    @Query("SELECT * FROM Book WHERE isDeleted = 0")
    suspend fun getAll(): List<Book>

    @Query("UPDATE Book SET isDeleted = 1 WHERE id = :id")
    suspend fun softDelete(id: Long)
}