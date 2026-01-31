package com.example.remedialucp2_077.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AuditDao {
    @Insert
    suspend fun insert(log: AuditLog)
}