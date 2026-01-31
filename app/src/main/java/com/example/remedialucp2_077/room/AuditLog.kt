package com.example.remedialucp2_077.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val tableName: String,
    val beforeData: String,
    val afterData: String,
    val timestamp: Long = System.currentTimeMillis()
)